package com.order.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class BusinessException extends RuntimeException{
	private static final long serialVersionUID = 1L;
//	
//	//private String origin;
//	private Long timestamp;
//	private Integer status;
	
	public BusinessException( String message) {
		super(message);
	}
	
	public BusinessException(String origin, String message) {
		super(message);
		//this.origin = origin;
	}

//	public BusinessException(Long timestamp, String message, Integer status) {
//		super(message);
//		this.status = status;
//		this.timestamp = timestamp;
//	}
	
	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
