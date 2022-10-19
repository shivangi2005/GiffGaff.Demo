package com.example.demo.controller;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.model.dto.APIError;
import com.example.demo.model.dto.ErrorDTO;
import com.example.demo.model.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.InvalidClassException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {InvalidInputException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO<APIError> handleInvlidInputException(InvalidInputException exception){
        return new ErrorDTO<>(new APIError(HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage()));
    }

}
