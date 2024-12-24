package com.cracker.request.validators;

import com.cracker.request.HashType;

import java.util.HashMap;
import java.util.Map;

public class HashValidatorMapper {

    private static final Map<HashType, HashValidator> hashTypeHashValidatorMap = new HashMap<>() ;

    public void registerMapper (HashValidator hashValidator, HashType hashType){
        hashTypeHashValidatorMap.putIfAbsent(hashType, hashValidator);
    }

    public HashValidator get (HashType hashType){
       return hashTypeHashValidatorMap.get(hashType);
    }


}
