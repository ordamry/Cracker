package com.cracker.utils;

import com.cracker.request.HashType;

import java.util.HashMap;
import java.util.Map;

public class HashCalculatorMapper {

    private static final Map<HashType, HashCalculator> hashTypeHashCalculatorMap = new HashMap<>() ;

    public void registerCalculatorMapper (HashCalculator hashCalculator, HashType hashType){
        hashTypeHashCalculatorMap.putIfAbsent(hashType, hashCalculator);
    }

    public HashCalculator get (HashType hashType){
        return hashTypeHashCalculatorMap.get(hashType);
    }
    public Map<HashType, HashCalculator> getMapper (){
        return hashTypeHashCalculatorMap ;
    }
}
