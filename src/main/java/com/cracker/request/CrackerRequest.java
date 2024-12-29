package com.cracker.request;

public class CrackerRequest {
    private String hashToCrack ;
    private EngineType engineType ;
    private HashType hashType ;

    public CrackerRequest(String hashToCrack, EngineType engineType, HashType hashType)
    {
        this.hashToCrack = hashToCrack ;
        this.engineType = engineType ;
        this.hashType = hashType ;
        
    }

    public String getHashToCrack() {
        return hashToCrack;

    }

    public HashType getHashType() {
        return hashType;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setHashToCrack(String hashToCrack) {
        this.hashToCrack = hashToCrack;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void setHashType(HashType hashType) {
        this.hashType = hashType;
    }

    @Override
    public String toString() {
        return "Request{" +
                "hashToCrack='" + hashToCrack + '\'' +
                ", engineType=" + engineType +
                '}';
    }
}
