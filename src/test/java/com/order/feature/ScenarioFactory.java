package com.order.feature;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.order.domain.dto.request.OrderRequestDto;
import com.order.domain.dto.request.OrderRequestUpdateDto;
import com.order.domain.dto.response.OfferResponseDto;
import com.order.domain.dto.response.OrderResponseDto;
import com.order.domain.dto.response.ProductResponseDto;
import com.order.domain.model.Order;

import lombok.var;

public class ScenarioFactory {

	public static Order newOrder() {
		var order = new Order();
	//	order.setId("01");
//		order.setIdProduct("03");
//		order.setIdOffer("03");
//		order.setDescription("Tomada para pele");
//		order.setDescription("10");
		order.setInstante(LocalDate.ofInstant(Instant.now(), ZoneOffset.systemDefault()));
		return order;
	}

	public static OrderRequestDto orderRequestDto() {
		var order = new OrderRequestDto();
//		order.setIdProduct("03");
//		order.setIdOffer("03");
//		order.setDescription("Tomada para pele");
//		order.setDescription("10");
		 order.setInstante(LocalDate.ofInstant(Instant.now(),
		 ZoneOffset.systemDefault()));
		return order;
	}
	
	public static OrderResponseDto orderResponseDto() {
		var order = new OrderResponseDto();
//		order.setIdProduct("03");
//		order.setIdOffer("03");
		order.setInstante(LocalDate.ofInstant(Instant.now(), ZoneOffset.systemDefault()));
//		order.setDescription("Tomada para pele");
//		order.setDescription("10");
		return order;
	}

	public static OfferResponseDto offerResponseDto() {
		var order = new OfferResponseDto();
		order.setIdProduct("03");
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

	public static OrderRequestUpdateDto newOrderRequesUpdate() {
		OrderRequestUpdateDto order = new OrderRequestUpdateDto();
		order.setIdProduct("04");
		order.setIdOffer("04");
		order.setDescription("Tomada para pele");
		order.setDescription("10");
		return order;
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
		return Optional.of( offerResponseDto());
	}
	
	public static Optional<OfferResponseDto> newOfferNullo() {
		return Optional.empty();
	}
	public static OrderRequestDto orderRequestDto1() {
		var order = new OrderRequestDto();
//		order.setIdProduct("15");
//		order.setIdOffer("03");
//		order.setDescription("Tomada para pele");
//		order.setDescription("10");
		 order.setInstante(LocalDate.ofInstant(Instant.now(),
		 ZoneOffset.systemDefault()));
		return order;
	}
}
