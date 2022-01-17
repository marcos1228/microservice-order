package com.order.domain.dto.response;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class ProductResponseDto {
	private Long id;
	private String name;
	private BigDecimal discount;
	private BigDecimal theamount;
	private BigDecimal price;
}
