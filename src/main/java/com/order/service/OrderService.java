package com.order.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.domain.dto.request.OrderRequestDto;
import com.order.domain.dto.response.OrderResponseDto;
import com.order.domain.model.Items;
import com.order.domain.model.Order;
import com.order.exception.BusinessException;
import com.order.exception.MessageBuilder;
import com.order.repository.OrderRepository;
import com.order.validator.OrderValidator;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OrderValidator orderValidator;

	@Autowired
	private MessageBuilder messageBuilder;

	public OrderResponseDto getByOrder(Long id) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new BusinessException(messageBuilder.getMessage("message.exception.order")));
		return modelMapper.map(order, OrderResponseDto.class);

	}

	public Page<OrderResponseDto> findByDescription( Pageable pageable) {
		Page<Order> list = orderRepository.findBy( pageable);
		return list.map(item -> modelMapper.map(item, OrderResponseDto.class));
	}

	@Transactional
	public OrderResponseDto save(OrderRequestDto orderRequestDto) {
		Order order = modelMapper.map(orderRequestDto, Order.class);
		orderValidator.validatorProduct(orderRequestDto);
		orderValidator.validatorOffer(orderRequestDto);
		orderValidator.validatorValorTotal(orderRequestDto);
		order.setInstante(LocalDate.ofInstant(Instant.now(), ZoneOffset.systemDefault()));
		for (Items i : order.getItems()) {
			i.setOrder(order);
		}
		Order save = orderRepository.save(order);
		return modelMapper.map(save, OrderResponseDto.class);
	}

	@Transactional
	public void delete(Long id) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new BusinessException(messageBuilder.getMessage("message.exception.order")));
		orderRepository.delete(order);
	}
}
