package br.com.victorio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.victorio.exceptions.ExceptionResponse;
import br.com.victorio.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExcepetion(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponde = new ExceptionResponse(
				new Date(), 
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponde, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExcepetion(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponde = new ExceptionResponse(
				new Date(), 
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponde, HttpStatus.BAD_REQUEST);
	}

}
