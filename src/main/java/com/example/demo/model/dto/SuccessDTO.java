package com.example.demo.model.dto;

import java.io.Serializable;

public class SuccessDTO<T> extends ResponseDTO<T> implements Serializable {


    public SuccessDTO(T response) {
        super(true, response, null);
    }
}
