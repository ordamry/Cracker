package com.cracker.crackingStrategy;

import com.cracker.request.HashType;

public class HashCrackerContext {

    private HashCrackingStrategy crackingStrategy ;

    public HashCrackerContext (HashCrackingStrategy crackingStrategy){
        this.crackingStrategy = crackingStrategy ;
    }
    public void setCrackingStrategy (HashCrackingStrategy crackingStrategy){
        this.crackingStrategy = crackingStrategy ;
    }
    public String crack (String hash, HashType hashType){
        return crackingStrategy.crackHash(hash, hashType);
    }
}
