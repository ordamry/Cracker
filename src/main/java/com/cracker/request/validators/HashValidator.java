package com.cracker.request.validators;

import com.cracker.request.HashType;


public abstract class HashValidator {

    protected HashValidator (HashValidatorMapper hashValidatorMapper){
        hashValidatorMapper.registerMapper(this, getHashType());
    }

    protected abstract HashType getHashType();

    public abstract boolean isValidHash(String hash);

}
