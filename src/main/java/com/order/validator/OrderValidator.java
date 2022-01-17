package com.order.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.controller.client.OfferClient;
import com.order.controller.client.ProductClient;
import com.order.domain.dto.request.OrderRequestDto;
import com.order.domain.dto.response.OfferResponseDto;
import com.order.domain.dto.response.ProductResponseDto;
import com.order.domain.model.Items;
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
		for(Items item : object.getItems()) {
			Optional<ProductResponseDto> product = productClient.getByProduct(item.getIdProduct());
			if(!product.isPresent()) {
				throw new BusinessException("Produto não encontrado "+item.getIdProduct());
			}
			if(!item.getName().equals(product.get().getName())) {
				throw new BusinessException("Nome produto não encontrado "+item.getName());
			}
			
		}
				
	}

	public void validatorOffer(OrderRequestDto object) {
		for(Items item: object.getItems()) {
			Optional<OfferResponseDto> optionalOffer = offerClient.getByOffer(object.getIdOffer());
			if (optionalOffer.isPresent()) {
				Long idProduct =item.getIdProduct();
				Long idProduct2 = optionalOffer.get().getIdProduct();
				if (!idProduct.equals(idProduct2)) {
					throw new BusinessException(messageBuilder.getMessage("message.exception.offernaocadastrada"));
				}
			} else {
				throw new BusinessException(messageBuilder.getMessage("message.exception.offer"));
			}
	}
	}
}