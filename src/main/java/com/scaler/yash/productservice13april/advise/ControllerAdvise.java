package com.scaler.yash.productservice13april.advise;

import com.scaler.yash.productservice13april.dto.ErrorDTO;
import com.scaler.yash.productservice13april.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some_status_code"); // this is not HTTP status code.
        dto.setMessage(exception.getMessage());
        return dto;
    }
}
