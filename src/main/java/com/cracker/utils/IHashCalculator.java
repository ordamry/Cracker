package com.cracker.utils;

import com.cracker.request.HashType;

import java.security.NoSuchAlgorithmException;

public interface IHashCalculator {
    HashType getHashType();

    String calculateHash (String str)throws NoSuchAlgorithmException;

}


