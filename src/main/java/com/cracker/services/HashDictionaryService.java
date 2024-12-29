package com.cracker.services;

import com.cracker.crackingStrategy.HashCrackingStrategy;
import com.cracker.repository.DictionaryRepository;
import com.cracker.request.HashType;
import com.cracker.utils.IHashCalculator;
import com.cracker.utils.HashCalculatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HashDictionaryService implements HashCrackingStrategy {

    private static final Map<HashType, Map<String, String>> crackingMap = new EnumMap<>(HashType.class) ;
    private final DictionaryRepository dictionaryRespository;
    private final HashCalculatorMapper hashCalculatorMapper;

    @Autowired
    public HashDictionaryService (DictionaryRepository dictionaryRepository, HashCalculatorMapper hashCalculatorMapper){
        this.dictionaryRespository = dictionaryRepository ;
        this.hashCalculatorMapper = hashCalculatorMapper ;
        loadDictionary();
    }

    private void loadDictionary() {
        List<String> passwords = dictionaryRespository.getDictionaryWords();
        for (String password: passwords) {
            for (Map.Entry<HashType, IHashCalculator> entry : hashCalculatorMapper.getMapper().entrySet()) {
                IHashCalculator calculator = entry.getValue();
                String hash ;
                try {
                    hash = calculator.calculateHash(password);
                } catch (NoSuchAlgorithmException e) {
                    System.out.println("Failed to calculate hash from type " + entry.getKey() + " for some password");
                    continue;
                }
                crackingMap.compute(entry.getKey(), (key,value)-> fillCrackingMap(value,hash,password));
            }
        }
    }

    private Map<String, String> fillCrackingMap(Map<String, String> value, String hash, String password) {
        Map<String, String> result ;
        if (value == null){
            result = new HashMap<>();
        }
        else{
            result=value ;
        }
        result.put(hash,password);
          return result ;
    }

    @Override
    public String crackHash(String hash, HashType hashType) {
        Map <String, String> result = crackingMap.get(hashType);
        return result.get(hash);
    }
}
