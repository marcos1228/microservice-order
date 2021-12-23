package com.order.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDtoResponse {
	private String message;
	//private String origin;

}
