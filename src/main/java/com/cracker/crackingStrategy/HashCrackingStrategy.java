package com.cracker.crackingStrategy;

import com.cracker.request.HashType;

public interface HashCrackingStrategy {

    String crackHash (String hash, HashType hashType);
}
