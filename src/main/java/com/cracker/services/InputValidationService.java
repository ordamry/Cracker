package com.cracker.services;

import com.cracker.request.HashType;
import com.cracker.request.CrackerRequest;
import com.cracker.request.validators.HashValidator;
import com.cracker.request.validators.HashValidatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputValidationService {

    private final HashValidatorMapper hashValidatorMapper;

    @Autowired
    public InputValidationService (HashValidatorMapper hashValidatorMapper){
        this.hashValidatorMapper = hashValidatorMapper ;
    }
    public boolean isValidRequest (CrackerRequest crackerRequest){
        return isValidHash (crackerRequest.getHashToCrack(), crackerRequest.getHashType()) ;
    }



    private boolean isValidHash(String hashToCrack, HashType hashType) {
        HashValidator hashValidator = hashValidatorMapper.getHashValidator(hashType) ;
        if (hashValidator == null) {
            System.out.println("failed to get validator for hash type " + hashType);
            throw new IllegalArgumentException("no validator for hash type " + hashType);
        }
        return hashValidator.isValidHash(hashToCrack) ;
    }


}
