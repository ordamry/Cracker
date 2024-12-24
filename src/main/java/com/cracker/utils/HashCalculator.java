package com.cracker.utils;

import com.cracker.request.HashType;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public abstract class HashCalculator {

    private static HashCalculatorMapper hashCalculatorMapper = new HashCalculatorMapper();

    protected HashCalculator(){
        hashCalculatorMapper.registerCalculatorMapper(this, getHashType());
    }

    public static HashCalculator getHashCalculator (HashType hashType){
        return hashCalculatorMapper.get(hashType);
    }

    protected abstract HashType getHashType();

    public abstract String calculateHash (String str)throws NoSuchAlgorithmException;

    public static Map<HashType, HashCalculator> getMapper(){
        return hashCalculatorMapper.getMapper() ;
    }
}


