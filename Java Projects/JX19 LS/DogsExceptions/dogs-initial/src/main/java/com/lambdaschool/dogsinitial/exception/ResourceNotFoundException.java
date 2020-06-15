package com.lambdaschool.dogsinitial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    // needs to extend class RuntimeException inorder to be seen as an official exception
    // anytime we want to return a "not found" response we need this class and everything in it

    private static final long serialVersionUID = 1L;
    // this will be used to serialize the object, basically it takes the blob of data and spits out something readable???
    // idk we will get to this later.

    public ResourceNotFoundException(String message){
        super(message);
    }

    public  ResourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }


}
