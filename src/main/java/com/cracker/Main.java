package com.cracker;

import com.cracker.crackingStrategy.HashCrackerContextChooser;
import com.cracker.repository.FileReaderRepository;
import com.cracker.request.EngineType;
import com.cracker.request.HashType;
import com.cracker.request.Request;
import com.cracker.request.validators.HashValidator;
import com.cracker.request.validators.NTLMHashValidator;
import com.cracker.services.CrackerService;
import com.cracker.services.HashDictionaryService;
import com.cracker.services.InputValidationService;
import com.cracker.utils.HashCalculator;
import com.cracker.utils.NtlmHashCalculator;

public class Main {
    public static void main(String[] args) {

        Request request = new Request("47BF8039A8506CD67C524A03FF84BA4E", EngineType.CUSTOM_ENGINE, HashType.NTLM);
        HashValidator hashValidator = new NTLMHashValidator();
        HashCalculator hashCalculator = new NtlmHashCalculator();
        InputValidationService inputValidationService = new InputValidationService();
        HashCrackerContextChooser hashCrackerContextChooser = new HashCrackerContextChooser(new HashDictionaryService(new FileReaderRepository("Wordlist.txt")));
        CrackerService crackerService = new CrackerService(inputValidationService,hashCrackerContextChooser);
        System.out.println(crackerService.handleRequest(request));

        }
    }
