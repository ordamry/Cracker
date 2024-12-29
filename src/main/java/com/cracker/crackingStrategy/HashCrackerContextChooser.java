package com.cracker.crackingStrategy;

import com.cracker.request.EngineType;
import com.cracker.services.HashDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HashCrackerContextChooser {

    private final HashDictionaryService hashDictionaryService;

    @Autowired
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
