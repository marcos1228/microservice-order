package com.order.config;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.domain.dto.response.ErrorDtoResponse;
import com.order.exception.BusinessException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> BusinessException(BusinessException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)

				.body(ErrorDtoResponse.builder().message(ex.getMessage()).build());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validation(MethodArgumentNotValidException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)

				.body(ErrorDtoResponse.builder().message(ex.getAllErrors().get(0).getDefaultMessage()).build());
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<?> errorNotFound(Exception ex) {

		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> internalServerError(Throwable ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)

				.body(ErrorDtoResponse.builder().message(ex.getMessage()).build());
	}

}
