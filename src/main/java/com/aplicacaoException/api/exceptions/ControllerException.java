package com.aplicacaoException.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
class ControlerException extends RuntimeException {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericException handleException(MethodArgumentNotValidException e) {

        GenericException generic = new GenericException(HttpStatus.BAD_REQUEST, e.getFieldError());

        return generic;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public GenericException2 handleException(Exception e) {

        GenericException2 generic = new GenericException2(HttpStatus.BAD_REQUEST, e.getMessage());

        return generic;
    }
}

