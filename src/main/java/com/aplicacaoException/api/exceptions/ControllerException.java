package com.aplicacaoException.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
class ControlerException extends RuntimeException {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleException(MethodArgumentNotValidException e) {

        GenericException generic = new GenericException(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getFieldError().getDefaultMessage(),
                "Um problema com este campo: " + e.getFieldError().getField());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generic);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {

        GenericException2 generic = new GenericException2(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generic);

    }
}

