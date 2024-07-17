package com.aplicacaoException.api.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@Getter
@Setter
@AllArgsConstructor
public class GenericException {

    private HttpStatus status;
    private
    FieldError message;

}

@Getter
@Setter
@AllArgsConstructor
class GenericException2 {

    private HttpStatus status;
    private
    String message;

}