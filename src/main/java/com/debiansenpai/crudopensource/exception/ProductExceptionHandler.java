package com.debiansenpai.crudopensource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> productNotFound(ProductError ex) {
        ErrorDTO generalError = new ErrorDTO(HttpStatus.NOT_FOUND.name(), ex.getMessage());
        return new ResponseEntity<>(generalError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CategoryError> categoryNotExists(CategoryError ex) {
        return new ResponseEntity<>(new CategoryError(), HttpStatus.NOT_FOUND);
    }
}
