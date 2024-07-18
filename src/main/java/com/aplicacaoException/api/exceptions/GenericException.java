package com.aplicacaoException.api.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericException {

    private String status;
    private String message;
    private String cause;

}

@Getter
@Setter
@AllArgsConstructor
class GenericException2 {

    private String status;
    private
    String message;

}