package com.cracker.utils;

import com.cracker.request.HashType;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class NtlmHashCalculator implements IHashCalculator{

    @Override
    public HashType getHashType() {
        return HashType.NTLM;
    }

    @Override
    public String calculateHash(String str) throws NoSuchAlgorithmException {
       byte[] bytes = getNtlmHash(str);
       return bytesToHex(bytes) ;
    }

     private byte[] getNtlmHash(String password) throws NoSuchAlgorithmException {
        byte[] utf16Bytes = passwordToUtf16Bytes(password);
        MessageDigest md4 = MessageDigest.getInstance("MD4");
        return md4.digest(utf16Bytes);
    }

    private byte[] passwordToUtf16Bytes(String password) {
        return password.getBytes(StandardCharsets.UTF_16LE);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString().toUpperCase();
    }

}

