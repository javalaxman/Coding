package com.iiht.market.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.iiht.market.exceoptions.CompnyNotFound;
import com.iiht.market.exceoptions.TurnOverCheckException;
import com.iiht.market.model.Successresponse;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(TurnOverCheckException.class)

	public ResponseEntity<Successresponse> handlerForUserNotFoundException(Exception e) {
		return new ResponseEntity<Successresponse>(new Successresponse(e.getMessage(), 200), HttpStatus.OK);

	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(CompnyNotFound.class)

	public ResponseEntity<Successresponse> handlerCompnyNotFoundException(Exception e) {
		return new ResponseEntity<Successresponse>(new Successresponse(e.getMessage(), 200), HttpStatus.OK);

	}

}
