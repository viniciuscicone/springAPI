package com.booksproject.api.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class ControlerException extends RuntimeException {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericException> handleException(Exception e) {

        GenericException generic = new GenericException(HttpStatus.BAD_GATEWAY, e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generic);
    }

  /*  @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericException> exception(Exception e) {
        GenericException generic = new GenericException(HttpStatus.ACCEPTED, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generic);
    }*/
}