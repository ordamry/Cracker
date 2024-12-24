package com.cracker.services;

import com.cracker.request.HashType;
import com.cracker.request.Request;
import com.cracker.request.validators.HashValidator;

public class InputValidationService {

    public boolean isValidRequest (Request request){
        return isValidHash (request.getHashToCrack(), request.getHashType()) ;
    }

    private boolean isValidHash(String hashToCrack, HashType hashType) {
        HashValidator hashValidator = HashValidator.getHashValidator(hashType) ;
        if (hashValidator == null) {
            System.out.println("failed to get validator for hash type " + hashType);
            throw new IllegalArgumentException("no validator for hash type " + hashType);
        }
        return hashValidator.isValidHash(hashToCrack) ;
    }


}
