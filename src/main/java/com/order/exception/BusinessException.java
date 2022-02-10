package com.order.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String origin, String message) {
		super(message);

	}

	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
