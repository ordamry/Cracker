package com.cracker.crackingStrategy;

import com.cracker.request.EngineType;
import com.cracker.services.HashDictionaryService;

public class HashCrackerContextChooser {

    private final HashDictionaryService hashDictionaryService;

    public HashCrackerContextChooser (HashDictionaryService hashDictionaryService){
        this.hashDictionaryService = hashDictionaryService ;
    }
    public HashCrackerContext createCrackerContext (EngineType engineType){
        return switch (engineType){
            case CUSTOM_ENGINE -> new HashCrackerContext(new CustomEngineCrackingStrategy(hashDictionaryService));
            case HASHCAT_ENGINE -> new HashCrackerContext(new HashcatCrackingStrategy());

        };

    }
}
