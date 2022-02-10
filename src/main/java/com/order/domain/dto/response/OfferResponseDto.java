package com.order.domain.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;


@Data
public class OfferResponseDto {
	private Long id;
	
	private Long idProduct;
	
	private String title;
	
	private LocalDate dateStart;
	
	private LocalDate dateEnd;
	
	private BigDecimal discount;
}
