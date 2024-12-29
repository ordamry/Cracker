package com.cracker.request;

public class CrackerResponse {
    private String id ;
    private String password ;

    public CrackerResponse (){

    }


    public String getId(){
        return id ;
    }

    public String getPassword(){
        return password ;
    }

    public void setPassword(String password){
        this.password=password ;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CrackerResponse{" +
                ", password='" + password + '\'' +
                '}';
    }
}
