package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> implements Serializable {

    private boolean success;
    private T response;
    private  APIError error;


    public ResponseDTO(boolean success, T response, APIError error) {
        this.success = success;
        this.response = response;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }

    public APIError getError() {
        return error;
    }

    public void setResponse(T response){
        this.response =response;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError(APIError error) {
        this.error = error;
    }
}
