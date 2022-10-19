package com.example.demo.model.dto;

import java.io.Serializable;

public class ErrorDTO<T> extends ResponseDTO<T> implements Serializable {
    public ErrorDTO( APIError error) {
        super(false, null, error);
    }
}
