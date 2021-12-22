package com.order.domain.dto.response;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderResponseDto {
	@ApiModelProperty(value = "id do order", example = "123")
	private String id;
	@ApiModelProperty(value = "id do produto", example = "123")
	private String idProduct;
	@ApiModelProperty(value = "id da offerta", example = "123")
	private String idOffer;
	@ApiModelProperty(value = "descrição do pedido", example = "luva")
	private String description;
	@ApiModelProperty(value = "quantidade do pedido", example = "11")
	private String theamount;
	@ApiModelProperty(value="Data do pedido", example = "yyyy/MM/dd")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate instante;
}
