package com.satish.shopsy.productservice8aug.advise;

import com.satish.shopsy.productservice8aug.dto.errorDTO;
import com.satish.shopsy.productservice8aug.exceptions.InvalidProductIdException;
import com.satish.shopsy.productservice8aug.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(InvalidProductIdException.class)
    ResponseEntity<errorDTO> handleInvalidProductIdException
            (InvalidProductIdException e){
        errorDTO dto = new errorDTO();
        dto.setCode("some random code");
        dto.setMessage(e.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<errorDTO> handleProductNotFoundException
            (ProductNotFoundException e){
        errorDTO dto = new errorDTO();
        dto.setCode("some random code");
        dto.setMessage("Product not found ...");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<errorDTO> handleException
            (Exception e){
        errorDTO dto = new errorDTO();
        dto.setCode("some random code");
        dto.setMessage("Product not found ...");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
