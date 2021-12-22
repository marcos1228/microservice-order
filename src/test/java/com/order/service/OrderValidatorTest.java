package com.order.service;



import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.order.controller.client.ProductClient;
import com.order.domain.dto.response.ProductResponseDto;
import com.order.exception.BusinessException;
import com.order.feature.ScenarioFactory;
import com.order.validator.OrderValidator;

import lombok.var;



@RunWith(MockitoJUnitRunner.class)
public class OrderValidatorTest {

	@InjectMocks
	private OrderValidator orderValidator;
	
	@Mock
	private ProductClient productClient;

	@Test
	public void validatorProduct_WhenReceivedOrderRequestDtoWithValidIdProduct_ExpectedSuccess() {
//		var orderRequestDto = ScenarioFactory.orderRequestDto();
//		Optional<ProductResponseDto> product = ScenarioFactory.newProduct();
//		when(productClient.getByProduct(any())).thenReturn(product);
//		
	}

	public void validatorProduct_WhenReceivedOrderRequestDtoWithInvalidIdProduct_ExpectedSuccess() {

	}

	@Test
	public void validatorProduct_WhenReceivedOrderRequestDtoWithValidIdOffer_ExpectedSuccess() {

	}

	@Test
	public void validatorProduct_WhenReceivedOrderRequestDtoWithInvalidIdOffer_ExpectedSuccess() {

	}

}
