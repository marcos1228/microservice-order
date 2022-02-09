package com.order.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.order.domain.model.Customer;
import com.order.domain.model.DeliveryAddress;
import com.order.domain.model.Items;

import lombok.Data;

@Data
public class OrderRequestDto {
	
	private Long idOffer;
	private LocalDate instante;
	@NotNull(message = "{valorTotal.notNull}")
	@Positive(message = "{valorTotal.positive}")
	private BigDecimal valorTotal;
	@NotNull(message = "{consumer.notNull}")
	private Customer consumer;
	@NotNull(message = "{deliveryAddress.notNull}")
	private DeliveryAddress deliveryAddress;
	@NotNull(message = "{items.notNull}")
	@Size(min = 1)
	private List<Items> items;
}
