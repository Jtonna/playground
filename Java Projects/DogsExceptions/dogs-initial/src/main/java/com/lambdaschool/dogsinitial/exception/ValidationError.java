package com.lambdaschool.dogsinitial.exception;

public class ValidationError {
    private String code;
    private String message;

    public ValidationError(String code, String message){
      // always needed to stop the obj from using the default constructor
        this.code = code;
        this.message = message;
    }

    public ValidationError(){
        // since i added a custom constructor spring needs to have the default constructor with no variables
    }

    // auto generated getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
