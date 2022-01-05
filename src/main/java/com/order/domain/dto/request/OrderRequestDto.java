package com.order.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.order.domain.model.Consumer;
import com.order.domain.model.DeliveryAddress;
import com.order.domain.model.Items;

import lombok.Data;

@Data
public class OrderRequestDto {
	private LocalDate instante;
	private BigDecimal valorTotal;
	private Consumer consumer;
	private DeliveryAddress deliveryAddress;
	private List<Items> items;
}
