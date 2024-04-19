package com.scaler.yash.productservice13april.advise;

import com.scaler.yash.productservice13april.dto.ErrorDTO;
import com.scaler.yash.productservice13april.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvise {

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ErrorDTO handleProductNotFoundException() {
//        ErrorDTO dto = new ErrorDTO();
//        dto.setCode("some_status_code"); // this is not HTTP status code.
//        dto.setMessage("Some exception has happened");
//        return dto;
//    }
@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<ErrorDTO> handleProductNotFoundException(){
    var errorDTO = new ErrorDTO();
    errorDTO.setCode("102");
    errorDTO.setMessage("No Products were found");

    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
}
}
