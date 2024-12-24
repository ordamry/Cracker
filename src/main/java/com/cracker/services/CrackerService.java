package com.cracker.services;

import com.cracker.crackingStrategy.HashCrackerContext;
import com.cracker.crackingStrategy.HashCrackerContextChooser;
import com.cracker.request.Request;

public class CrackerService {

    private final InputValidationService inputValidationService;
    private final HashCrackerContextChooser hashCrackerContextChooser;

    public CrackerService (InputValidationService inputValidationService, HashCrackerContextChooser hashCrackerContextChooser){
        this.inputValidationService = inputValidationService ;
        this.hashCrackerContextChooser = hashCrackerContextChooser ;
    }

    public String handleRequest (Request request){
       boolean isValidRequest =  inputValidationService.isValidRequest(request);
       if (!isValidRequest) {
           System.out.println("The request isn't valid " + request);
           return null ;
       }
       HashCrackerContext context = hashCrackerContextChooser.createCrackerContext(request.getEngineType());
       return context.crack(request.getHashToCrack(), request.getHashType());

    }
}
