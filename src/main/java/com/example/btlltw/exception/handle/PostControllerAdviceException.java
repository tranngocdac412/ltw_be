package com.example.btlltw.exception.handle;

import com.example.btlltw.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostControllerAdviceException {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleException(NotFoundException exception){
//        log.error(exception.getError().toString());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
