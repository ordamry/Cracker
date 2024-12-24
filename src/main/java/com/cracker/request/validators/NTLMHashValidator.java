package com.cracker.request.validators;

import com.cracker.request.HashType;

import java.util.regex.Pattern;

public class NTLMHashValidator extends HashValidator{
    private static final String NTLM_HASH_REGEX = "^[0-9a-fA-F]{32}$" ;

    @Override
    protected HashType getHashType() {
        return HashType.NTLM;
    }

    @Override
    public boolean isValidHash(String hash){
        return Pattern.matches(NTLM_HASH_REGEX, hash);
    }



}
