package com.order.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.controller.client.OfferClient;
import com.order.controller.client.ProductClient;
import com.order.domain.dto.request.OrderRequestDto;
import com.order.domain.dto.response.OfferResponseDto;
import com.order.domain.dto.response.ProductResponseDto;
import com.order.exception.BusinessException;
import com.order.exception.MessageBuilder;

@Service
public class OrderValidator {

	@Autowired
	private ProductClient productClient;

	@Autowired
	private OfferClient offerClient;

	@Autowired
	private MessageBuilder messageBuilder;

	public void validatorProduct(OrderRequestDto object) {
		Optional<ProductResponseDto> product = productClient.getByProduct(object.getIdProduct());
		if (product.isPresent()) {
		} else {
			throw new BusinessException(messageBuilder.getMessage("message.exception.product"));
		}
	}

	public void validatorOffer(OrderRequestDto object) {
		Optional<OfferResponseDto> optionalOffer = offerClient.getByOffer(object.getIdOffer());
		if (optionalOffer.isPresent()) {
			String idProduct = object.getIdProduct();
			String idProduct2 = optionalOffer.get().getIdProduct();
			if (!idProduct.equals(idProduct2)) {
				throw new BusinessException(messageBuilder.getMessage("message.exception.offernaocadastrada"));
			}
		} else {
			throw new BusinessException(messageBuilder.getMessage("Oferta não existe"));
		}
	}
}