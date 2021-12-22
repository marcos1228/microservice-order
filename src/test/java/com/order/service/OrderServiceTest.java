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
import com.order.domain.dto.response.ProductResponseDto;
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
		orderService.getByOrder("01");
		verify(orderRepository, times(1)).findById("01");
		verify(modelMapper, times(1)).map(order, OrderResponseDto.class);

	}

	@Test
	public void getByOrder_WhenSendIdOrderInvalid_ExpectedException() {
		var optionalOrderNullo = ScenarioFactory.optionalOrderNullo();
		when(orderRepository.findById("03")).thenReturn(optionalOrderNullo);
		assertThatThrownBy(() -> orderService.getByOrder("03")).isInstanceOf(BusinessException.class)
				.hasMessage(messageBuilder.getMessage("message.exception.order"));
		verify(orderRepository, times(1)).findById("03");

	}

	@Test
	public void save_WhenReceivedOrderRequestDtoValidAndIdProductAndIdOferIsValid_ExpectedSucess() {
		var order = ScenarioFactory.newOrder();
		var orderRequestDto = ScenarioFactory.orderRequestDto();
		when(modelMapper.map(orderRequestDto, Order.class)).thenReturn(order);
		doNothing().when(orderValidator).validatorProduct(orderRequestDto);
		doNothing().when(orderValidator).validatorOffer(orderRequestDto);
		orderService.save(orderRequestDto);
		verify(modelMapper, times(1)).map(orderRequestDto, Order.class);
		verify(this.orderValidator, times(1)).validatorProduct(orderRequestDto);
		verify(orderValidator, times(1)).validatorOffer(orderRequestDto);
	}

	@Test
	public void save_WhenReceivedOrderRequestDtoInValidOrIdProductAndIdOferIsInValid_ExpectedException() {
//		Optional<ProductResponseDto> product = ScenarioFactory.newProduct();
//		when(productClient.getByProduct(any(String.class))).thenReturn(product);
//		
//		
		
		
	}

	@Test
	public void findByDescription_WhenCallMethod_ExpectedSucess() {
		var newPageable = ScenarioFactory.newPageable();
		var newPage = ScenarioFactory.newPage();
		var description = "Tomada para pele";
		when(orderRepository.findByDescriptionContainingIgnoreCase(description, newPageable)).thenReturn(newPage);
		orderService.findByDescription(description, newPageable);
		verify(orderRepository, times(1)).findByDescriptionContainingIgnoreCase(description, newPageable);
	}

	@Test
	public void update_WhenReceivingValidBaseIdAndOrderUpdateDtoRequestWittAllFieldsValidated_ExpectedSucess() {
		var optionalOrder = ScenarioFactory.newOptionalOrder();
		var orderRequesUpdate = ScenarioFactory.newOrderRequesUpdate();
		when(orderRepository.findById(optionalOrder.get().getId())).thenReturn(optionalOrder);
		when(orderRepository.save(optionalOrder.get())).thenReturn(optionalOrder.get());
		orderService.update("01", orderRequesUpdate);
		verify(orderRepository, times(1)).findById(optionalOrder.get().getId());
		verify(orderRepository, times(1)).save(optionalOrder.get());
		
	}

	@Test
	public void update_WhenReceivingInvalidBaseIdOrOrderfferUpdateRequestWithSomeInvalidFields_ExpectedException() {
		var orderRequestUpdate = ScenarioFactory.newOrderRequesUpdate();
		var optionalOrderNullo = ScenarioFactory.optionalOrderNullo();
		when(orderRepository.findById("02")).thenReturn(optionalOrderNullo);
		assertThatThrownBy(() -> orderService.update("02", orderRequestUpdate)).isInstanceOf(BusinessException.class)
				.hasMessage(messageBuilder.getMessage("message.exception.order"));
		verify(orderRepository, times(1)).findById("02");
	}

	@Test
	public void delete_WhenReceivingValidIdOnBase_ExpectedSucess() {
		var order = ScenarioFactory.newOrder();
		var optionalOrder = ScenarioFactory.newOptionalOrder();
		when(orderRepository.findById("02")).thenReturn(optionalOrder);
		orderService.delete("02");
		verify(orderRepository, times(1)).findById("02");
		verify(orderRepository, times(1)).delete(order);
	}

	@Test
	public void delete_WhenReceivingInvalidBaseId_ExpectedException() {
		var optionalOrderNullo = ScenarioFactory.optionalOrderNullo();
		when(orderRepository.findById("03")).thenReturn(optionalOrderNullo);
		assertThatThrownBy(() -> orderService.delete("03")).isInstanceOf(BusinessException.class)
				.hasMessage(messageBuilder.getMessage("message.exception.order"));
		verify(orderRepository, times(1)).findById("03");

	}
}
