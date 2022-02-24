package com.order.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.order.domain.dto.response.OfferResponseDto;
import com.order.domain.model.Customer;
import com.order.domain.model.DeliveryAddress;
import com.order.domain.model.Items;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderRequestDto {
	@ApiModelProperty(value = "Id da offerta", example = "123")
	private List<Long> idOffer;
	
	@ApiModelProperty(value = "data do instante do pedido", example = "dd/MM/yyyy")
	private LocalDate instante;
	
	@ApiModelProperty(value = "valor total do pedido", example = "240")
	@NotNull(message = "{valorTotal.notNull}")
	@Positive(message = "{valorTotal.positive}")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(value = "nome do consumidor", example = "Maria")
	@NotNull(message = "{consumer.notNull}")
	private Customer consumer;
	
	@ApiModelProperty(value = "Endereço de entrega", example = "Rua 4...")
	@NotNull(message = "{deliveryAddress.notNull}")
	private DeliveryAddress deliveryAddress;
	
	@ApiModelProperty(value = "Itens do pedido", example = "Dorflex, tossilax")
	@NotNull(message = "{items.notNull}")
	@Size(min = 1)
	private List<Items> items;
}
