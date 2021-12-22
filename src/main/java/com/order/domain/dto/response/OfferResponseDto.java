package com.order.domain.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OfferResponseDto {
	@ApiModelProperty(value="id da offerta", example = "123")
	private Long id;
	@ApiModelProperty(value = "id do troduto", example = "111")
	private String idProduct;
	@ApiModelProperty(value = "titulo da offerta", example = "Oferta de natal")
	private String title;
	@ApiModelProperty(value = "data inicio da offerta", example = "yyyy/MM/dd")
	private LocalDate dateStart;
	@ApiModelProperty(value = "data fim da offerta", example = "yyyy/MM/dd")
	private LocalDate dateEnd;
	@ApiModelProperty(value = "desconto da offerta", example = "2%")
	private BigDecimal discount;

}
