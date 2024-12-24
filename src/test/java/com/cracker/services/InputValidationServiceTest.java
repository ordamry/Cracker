package com.cracker.services;

import com.cracker.request.EngineType;
import com.cracker.request.HashType;
import com.cracker.request.Request;
import com.cracker.request.validators.HashValidator;
import com.cracker.request.validators.NTLMHashValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationServiceTest {
    private static InputValidationService inputValidationService ;

    @BeforeAll
    static void setupClass () {
        NTLMHashValidator ntlmHashValidator = new NTLMHashValidator();
        inputValidationService = new InputValidationService();
    }

    @Test
    void givenValidNtlmHash_WhenTestingRequestValidation_ThenReturnTrue() {
        Request request = new Request("47BF8039A8506CD67C524A03FF84BA4E", EngineType.CUSTOM_ENGINE, HashType.NTLM);
        boolean isValidRequest = inputValidationService.isValidRequest(request);
        Assertions.assertTrue(isValidRequest, "NTLM hash is valid, but inputValidationService return false");
    }

    @Test
    void giveNtlmHash_WhenTestingHashValidation_ThenReturnTrueIfTheHashValid(){
        Request request = new Request("47BF8039A8506CD67C524A03FF84BA4E", EngineType.CUSTOM_ENGINE, HashType.NTLM);
        HashValidator hashValidator = HashValidator.getHashValidator(request.getHashType()) ;
        boolean isValidHash = hashValidator.isValidHash(request.getHashToCrack());
        Assertions.assertTrue(isValidHash, "NTLM hash is not valid");
    }



}