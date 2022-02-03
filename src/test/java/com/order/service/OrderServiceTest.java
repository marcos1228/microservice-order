package com.order.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.order.controller.client.ProductClient;
import com.order.domain.dto.response.OrderResponseDto;
import com.order.domain.model.Order;
import com.order.exception.BusinessException;
import com.order.exception.MessageBuilder;
import com.order.feature.ScenarioFactory;
import com.order.repository.OrderRepository;
import com.order.validator.OrderValidator;

import lombok.var;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
	@InjectMocks
	private OrderService orderService;

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private ModelMapper modelMapper;

	@Mock
	private OrderValidator orderValidator;

	@Mock
	private MessageBuilder messageBuilder;

	@Mock
	private ProductClient productClient;

	@Test
	public void getByOrder_WhenSendIdOrderValid_ExpectedSucess() {
		var order = ScenarioFactory.newOrder();
		var optionalOrder = ScenarioFactory.newOptionalOrder();
		var orderResponseDto = ScenarioFactory.orderResponseDto();
		when(orderRepository.findById(order.getId())).thenReturn(optionalOrder);
		when(modelMapper.map(order, OrderResponseDto.class)).thenReturn(orderResponseDto);
		orderService.getByOrder(order.getId());
		verify(orderRepository, times(1)).findById(order.getId());
		verify(modelMapper, times(1)).map(order, OrderResponseDto.class);

	}

	@Test
	public void getByOrder_WhenSendIdOrderInvalid_ExpectedException() {
		var optionalOrderNullo = ScenarioFactory.optionalOrderNullo();
		when(orderRepository.findById(Long.valueOf(3))).thenReturn(optionalOrderNullo);
		assertThatThrownBy(() -> orderService.getByOrder(Long.valueOf(3))).isInstanceOf(BusinessException.class)
				.hasMessage(messageBuilder.getMessage("message.exception.order"));
		verify(orderRepository, times(1)).findById(Long.valueOf(3));

	}

	@Test
	public void save_WhenReceivedOrderRequestDtoValidAndIdProductAndIdOferIsValid_ExpectedSucess() {
		var order = ScenarioFactory.newOrder();
		var orderRequestDto = ScenarioFactory.orderRequestDto();
		when(modelMapper.map(orderRequestDto, Order.class)).thenReturn(order);
		doNothing().when(orderValidator).validatorProduct(orderRequestDto);
		doNothing().when(orderValidator).validatorOffer(orderRequestDto);
		doNothing().when(orderValidator).validatorValorTotal(orderRequestDto);
		orderService.save(orderRequestDto);
		verify(modelMapper, times(1)).map(orderRequestDto, Order.class);
		verify(this.orderValidator, times(1)).validatorProduct(orderRequestDto);
		verify(orderValidator, times(1)).validatorOffer(orderRequestDto);
	}

	@Test
	public void save_WhenReceivedOrderRequestDtoInValidOrIdProductAndIdOferIsInValid_ExpectedException() {

	}

	@Test
	public void findByDescription_WhenCallMethod_ExpectedSucess() {
		var newPageable = ScenarioFactory.newPageable();
		var newPage = ScenarioFactory.newPage();
		when(orderRepository.findBy(newPageable)).thenReturn(newPage);
		orderService.findByDescription(newPageable);
		verify(orderRepository, times(1)).findBy(newPageable);
	}

	@Test
	public void delete_WhenReceivingValidIdOnBase_ExpectedSucess() {
		var order = ScenarioFactory.newOrder();
		var optionalOrder = ScenarioFactory.newOptionalOrder();
		when(orderRepository.findById(Long.valueOf(2))).thenReturn(optionalOrder);
		orderService.delete(Long.valueOf(2));
		verify(orderRepository, times(1)).findById(Long.valueOf(2));
		verify(orderRepository, times(1)).delete(order);
	}

	@Test
	public void delete_WhenReceivingInvalidBaseId_ExpectedException() {
		var optionalOrderNullo = ScenarioFactory.optionalOrderNullo();
		when(orderRepository.findById(Long.valueOf(3))).thenReturn(optionalOrderNullo);
		assertThatThrownBy(() -> orderService.delete(Long.valueOf(3))).isInstanceOf(BusinessException.class)
				.hasMessage(messageBuilder.getMessage("message.exception.order"));
		verify(orderRepository, times(1)).findById(Long.valueOf(3));

	}
}
