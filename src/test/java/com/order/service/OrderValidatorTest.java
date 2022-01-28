package com.order.service;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.order.controller.client.OfferClient;
import com.order.controller.client.ProductClient;
import com.order.domain.dto.response.OfferResponseDto;
import com.order.domain.dto.response.ProductResponseDto;
import com.order.domain.model.Items;
import com.order.exception.BusinessException;
import com.order.exception.MessageBuilder;
import com.order.feature.ScenarioFactory;
import com.order.validator.OrderValidator;

import lombok.var;

@RunWith(MockitoJUnitRunner.class)
public class OrderValidatorTest {

	@InjectMocks
	private OrderValidator orderValidator;

	@Mock
	private ProductClient productClient;

	@Mock
	private OfferClient offerClient;

	@Mock
	private MessageBuilder messageBuilder;

	@Test
	public void validatorProduct_WhenReceivedOrderRequestDtoWithValidIdProduct_ExpectedSuccess() {
		

	}

	@Test
	public void validatorProduct_WhenReceivedOrderRequestDtoWithInvalidIdProduct_ExpectedException() {
		var orderRequestDto = ScenarioFactory.orderRequestDto();
		var product = ScenarioFactory.newProductNullo();
//		when(productClient.getByProduct("03")).thenReturn(product);
//		assertThatThrownBy(() -> orderValidator.validatorProduct(orderRequestDto)).isInstanceOf(BusinessException.class)
//				.hasMessage(messageBuilder.getMessage("message.exception.product"));
//		verify(productClient).getByProduct("03");

	}

	@Test
	public void validatorOffer_WhenReceivedOrderRequestDtoWithValidIdOfferAndIProductEqualIdProduct2_ExpectedSuccess() {
//		var orderRequestDto = ScenarioFactory.orderRequestDto();
//		Optional<OfferResponseDto> newOffer = ScenarioFactory.newOffer1();
//		when(offerClient.getByOffer(any())).thenReturn(newOffer);
//		orderValidator.validatorOffer(orderRequestDto);
//		verify(offerClient, times(1)).getByOffer(any());
	}

	@Test
	public void validatorOffer_WhenReceivedOrderRequestDtoWithValidIdOfferAndIProductDifferentIdProduct2_ExpectedSuccess() {
//		var orderRequestDto = ScenarioFactory.orderRequestDto();
//		Optional<OfferResponseDto> newOffer = ScenarioFactory.newOffer();
//		when(offerClient.getByOffer(any())).thenReturn(newOffer);
//		assertThatThrownBy(() -> orderValidator.validatorOffer(orderRequestDto)).isInstanceOf(BusinessException.class);
//		verify(offerClient, times(1)).getByOffer(any());
	}

	@Test
	public void validatorProduct_WhenReceivedOrderRequestDtoWithInvalidIdOffer_ExpectedSuccess() {
//		var orderRequestDto = ScenarioFactory.orderRequestDto();
//		var offer = ScenarioFactory.newOfferNullo();
//		when(offerClient.getByOffer(any())).thenReturn(offer);
////		assertThatThrownBy(() -> orderValidator.validatorOffer(orderRequestDto)).isInstanceOf(BusinessException.class)
//				.hasMessage(messageBuilder.getMessage("message.exception.offer"));
//		verify(offerClient).getByOffer("03");
	}

}
