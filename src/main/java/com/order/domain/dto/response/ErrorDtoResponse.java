package com.order.domain.dto.response;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDtoResponse {
	//private Long timestamp;
	private String message;
	//private Integer status;
	//private String origin;
	

}
