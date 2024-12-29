package com.cracker.utils;

import com.cracker.request.HashType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HashCalculatorMapper {

    private final Map<HashType, IHashCalculator> hashTypeHashCalculatorMap = new HashMap<>() ;

    @Autowired
    public HashCalculatorMapper (List<IHashCalculator> hashCalculatorList){
        for (IHashCalculator hashCalculator: hashCalculatorList){
            registerCalculatorMapper(hashCalculator, hashCalculator.getHashType());
        }
    }

    private void registerCalculatorMapper (IHashCalculator hashCalculator, HashType hashType){
        hashTypeHashCalculatorMap.putIfAbsent(hashType, hashCalculator);
    }

    public IHashCalculator get (HashType hashType){
        return hashTypeHashCalculatorMap.get(hashType);
    }
    public Map<HashType, IHashCalculator> getMapper (){
        return hashTypeHashCalculatorMap ;
    }
}
