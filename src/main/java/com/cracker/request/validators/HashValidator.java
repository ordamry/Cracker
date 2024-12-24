package com.cracker.request.validators;

import com.cracker.request.HashType;


public abstract class HashValidator {

    private static HashValidatorMapper hashValidatorMapper = new HashValidatorMapper() ;

    protected HashValidator (){
        hashValidatorMapper.registerMapper(this, getHashType());
    }
    public static HashValidator getHashValidator (HashType hashType){
        return hashValidatorMapper.get(hashType);
    }

    protected abstract HashType getHashType();


    public abstract boolean isValidHash(String hash);

}
