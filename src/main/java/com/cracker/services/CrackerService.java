package com.cracker.services;

import com.cracker.crackingStrategy.HashCrackerContext;
import com.cracker.crackingStrategy.HashCrackerContextChooser;
import com.cracker.request.CrackerRequest;
import com.cracker.request.CrackerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CrackerService {

    private final InputValidationService inputValidationService;
    private final HashCrackerContextChooser hashCrackerContextChooser;

    @Autowired
    public CrackerService (InputValidationService inputValidationService, HashCrackerContextChooser hashCrackerContextChooser){
        this.inputValidationService = inputValidationService ;
        this.hashCrackerContextChooser = hashCrackerContextChooser ;
    }

    public CrackerResponse handleRequest (CrackerRequest crackerRequest){
        CrackerResponse crackerResponse = new CrackerResponse();
        crackerResponse.setId(String.valueOf(UUID.randomUUID()));
       boolean isValidRequest =  inputValidationService.isValidRequest(crackerRequest);
       if (!isValidRequest) {
           System.out.println("The request isn't valid " + crackerRequest);
           return crackerResponse ;
       }
       HashCrackerContext context = hashCrackerContextChooser.createCrackerContext(crackerRequest.getEngineType());
       String password = context.crack(crackerRequest.getHashToCrack(), crackerRequest.getHashType());
       crackerResponse.setPassword(password);
       return crackerResponse ;


    }
}
