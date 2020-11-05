package br.com.crcarvalho.poupanca.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiErrorResponse {
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> handleArithmeticException(ArithmeticException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
}
