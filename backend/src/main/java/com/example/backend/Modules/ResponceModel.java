package com.example.backend.Modules;

public class ResponceModel {

    private String message;

    public ResponceModel(String message) {
        this.message = message;
    }

    public ResponceModel(){
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
