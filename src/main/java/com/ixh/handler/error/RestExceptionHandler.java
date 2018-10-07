package com.ixh.handler.error;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ixh.exception.ServiceExceptionCO;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	 @Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
	   
	   @ExceptionHandler(Exception.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
	           EntityNotFoundException ex) {
	       ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }
}
