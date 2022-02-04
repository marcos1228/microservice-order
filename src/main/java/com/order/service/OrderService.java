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

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		log.info("id [{}] will be for search for!", id);
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new BusinessException(messageBuilder.getMessage("message.exception.order")));
		log.warn("The return [{}]", order);
		return modelMapper.map(order, OrderResponseDto.class);

	}

	public Page<OrderResponseDto> findByDescription(Pageable pageable) {
		Page<Order> list = orderRepository.findBy(pageable);
		log.info("Orders will be listed in pageable form.");
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
		log.info("Successfully saved!");
		return modelMapper.map(save, OrderResponseDto.class);
	}

	@Transactional
	public void delete(Long id) {
		log.info("The id delete[{}]", id);
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new BusinessException(messageBuilder.getMessage("message.exception.order")));
		log.warn("The order delete [{}]", order);
		orderRepository.delete(order);
	}
}
