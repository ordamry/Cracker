package com.cracker.crackingStrategy;

import com.cracker.request.HashType;
import com.cracker.services.HashDictionaryService;

public class CustomEngineCrackingStrategy implements HashCrackingStrategy{

    private final HashDictionaryService hashDictionaryservice;

    public CustomEngineCrackingStrategy (HashDictionaryService hashDictionaryService){
        this.hashDictionaryservice = hashDictionaryService ;
    }
    @Override
    public String crackHash (String hash, HashType hashType){
        return hashDictionaryservice.crackHash(hash, hashType);
    }
}
