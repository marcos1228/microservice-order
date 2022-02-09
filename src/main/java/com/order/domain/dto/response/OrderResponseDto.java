package com.order.domain.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.order.domain.model.Customer;
import com.order.domain.model.DeliveryAddress;
import com.order.domain.model.Items;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderResponseDto {
	@ApiModelProperty(value = "id do pedido", example = "123")
	private Long id;
	@ApiModelProperty(value = "id da oferta", example = "1234")
	private Long idOffer;
	@ApiModelProperty(value = "data do instante do pedido", example = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate instante;
	@ApiModelProperty(value = "valor total do pedido", example = "240")
	private BigDecimal valorTotal;
	@ApiModelProperty(value = "nome do consumidor", example = "Maria")
	private Customer consumer;
	@ApiModelProperty(value = "Endereço de entrega", example = "Rua 4...")
	private DeliveryAddress deliveryAddress;
	@ApiModelProperty(value = "Itens do pedido", example = "Dorflex, tossilax")
	private List<Items> items;
}
