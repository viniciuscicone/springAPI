package com.aplicacaoException.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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

    @ExceptionHandler({ HttpMessageNotReadableException.class })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> resolveException(HttpMessageNotReadableException ex) {
        String message = "Please provide Request Body in valid JSON format";
        List<String> messages = new ArrayList<>(1);
        messages.add(message);
        return new ResponseEntity<>(new ExceptionResponse(messages, HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }
}

class ExceptionResponse {
    private String error;
    private Integer status;
    private List<String> messages;
    private Instant timestamp;

    public ExceptionResponse(List<String> messages, String error, Integer status) {
        setMessages(messages);
        this.error = error;
        this.status = status;
        this.timestamp = Instant.now();
    }

    public List<String> getMessages() {

        return messages == null ? null : new ArrayList<>(messages);
    }

    public final void setMessages(List<String> messages) {

        if (messages == null) {
            this.messages = null;
        } else {
            this.messages = Collections.unmodifiableList(messages);
        }
    }

}