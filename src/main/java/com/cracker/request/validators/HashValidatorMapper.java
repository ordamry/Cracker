package com.cracker.request.validators;

import com.cracker.request.HashType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HashValidatorMapper {

    private final Map<HashType, HashValidator> hashTypeHashValidatorMap = new HashMap<>() ;

    public void registerMapper (HashValidator hashValidator, HashType hashType){
        hashTypeHashValidatorMap.putIfAbsent(hashType, hashValidator);
    }

    public HashValidator getHashValidator (HashType hashType){
       return hashTypeHashValidatorMap.get(hashType);
    }


}
