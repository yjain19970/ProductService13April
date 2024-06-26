package com.scaler.yash.productservice13april.advise;

import com.scaler.yash.productservice13april.dto.ErrorDTO;
import com.scaler.yash.productservice13april.exception.CategoryNotFoundException;
import com.scaler.yash.productservice13april.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some_status_code"); // this is not HTTP status code.
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some_status_code"); // this is not HTTP status code.
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
