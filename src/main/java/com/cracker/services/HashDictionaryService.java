package com.cracker.services;

import com.cracker.crackingStrategy.HashCrackingStrategy;
import com.cracker.repository.DictionaryRepository;
import com.cracker.request.HashType;
import com.cracker.utils.HashCalculator;
import java.security.NoSuchAlgorithmException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashDictionaryService implements HashCrackingStrategy {

    private static final Map<HashType, Map<String, String>> crackingMap = new EnumMap<>(HashType.class) ;
    private final DictionaryRepository dictionaryRespository;

    public HashDictionaryService (DictionaryRepository dictionaryRepository){
        this.dictionaryRespository = dictionaryRepository ;
        loadDictionary();
    }

    private void loadDictionary() {
        List<String> passwords = dictionaryRespository.getDictionaryWords();
        for (String password: passwords) {
            for (Map.Entry<HashType, HashCalculator> entry : HashCalculator.getMapper().entrySet()) {
                HashCalculator calculator = entry.getValue();
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
