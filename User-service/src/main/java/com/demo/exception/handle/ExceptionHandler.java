package com.demo.exception.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseCode> handlerDataNotFoundException(DataNotFoundException d){
		return new ResponseEntity<ResponseCode>(new ResponseCode(d.getMessage(),404),HttpStatus.NOT_FOUND);
	}
}
