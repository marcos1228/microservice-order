package com.order.feature;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.order.domain.dto.request.OrderRequestDto;
import com.order.domain.dto.response.OfferResponseDto;
import com.order.domain.dto.response.OrderResponseDto;
import com.order.domain.dto.response.ProductResponseDto;
import com.order.domain.model.Customer;
import com.order.domain.model.DeliveryAddress;
import com.order.domain.model.Items;
import com.order.domain.model.Order;

import lombok.var;

public class ScenarioFactory {

	public static Order newOrder() {
		var order = new Order();
		
		order.setIdOffer(Long.valueOf("1"));
		
		order.setInstante(LocalDate.ofInstant(Instant.now(), ZoneOffset.systemDefault()));
		
		order.setValorTotal(BigDecimal.valueOf(240));
		
		order.setConsumer(new Customer());
		
		order.setDeliveryAddress(new DeliveryAddress());
		
		order.setItems(new ArrayList<Items>());
		
		return order;
	}

	public static OrderRequestDto orderRequestDto() {
		var order = new OrderRequestDto();
		order.setIdOffer(Long.valueOf("1"));
		order.setInstante(LocalDate.ofInstant(Instant.now(), ZoneOffset.systemDefault()));
		order.setValorTotal(BigDecimal.valueOf(240));
		order.setConsumer(new Customer());
		order.setDeliveryAddress(new DeliveryAddress());
		order.setItems(new ArrayList<Items>());
		return order;
	}

	public static OrderResponseDto orderResponseDto() {
		var order = new OrderResponseDto();
		
		order.setIdOffer(Long.valueOf("1"));
		
		order.setInstante(LocalDate.ofInstant(Instant.now(), ZoneOffset.systemDefault()));
		
		order.setValorTotal(BigDecimal.valueOf(240));
		
		order.setConsumer(new Customer());
		
		order.setDeliveryAddress(new DeliveryAddress());
		
		return order;
	}

	public static OfferResponseDto offerResponseDto() {
		
		var order = new OfferResponseDto();
		
		return order;
	}

	public static Optional<Order> newOptionalOrder() {
		
		return Optional.of(newOrder());
	}

	public static Optional<Order> optionalOrderNullo() {
		
		return Optional.empty();
	}

	public static PageRequest newPageable() {
		
		PageRequest pageable = PageRequest.ofSize(5);
		
		return pageable;

	}

	public static Page<Order> newPage() {
		
		ArrayList<Order> order = new ArrayList<>();
		
		order.add(new Order());
		
		return new PageImpl<>(order);
	}

	public static Optional<ProductResponseDto> newProduct() {
		
		return Optional.of(new ProductResponseDto());
	}

	public static Optional<ProductResponseDto> newProductNullo() {
		
		return Optional.empty();
	}

	public static Optional<OfferResponseDto> newOffer() {
		
		return Optional.of(new OfferResponseDto());
	}

	public static Optional<OfferResponseDto> newOffer1() {
		
		return Optional.of(offerResponseDto());
	}

	public static Optional<OfferResponseDto> newOfferNullo() {
		
		return Optional.empty();
	}

}
