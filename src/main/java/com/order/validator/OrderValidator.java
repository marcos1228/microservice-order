package com.order.validator;

import java.math.BigDecimal;
import java.util.List;
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

		for (Items item : object.getItems()) {

			Optional<ProductResponseDto> product = productClient.getByProduct(item.getIdProduct());

			if (!product.isPresent()) {

				throw new BusinessException("message.exception.product" + item.getIdProduct());

			}
		}

	}

	public void validatorOffer(OrderRequestDto object) {

		for (Items item : object.getItems()) {
			List<Long> idOffer = item.getIdOffer();
			System.out.println(idOffer);
			
			if (idOffer != null) {

				List<Long> byOffer = offerClient.getByOffer(idOffer);

				// if (byOffer.isEmpty()) {

				// Long idProduct = item.getIdProduct();

				/// Long idProduct2 = optionalOffer.get().getIdProduct();

//					if (!idProduct.equals(idProduct2)) {
//						
//						throw new BusinessException(messageBuilder.getMessage("message.exception.offernaocadastrada"));
//						
//					}
			}
		}
		}
	//}

	// }

	public void validatorValorTotal(OrderRequestDto object) {

		List<Items> items = object.getItems();

		BigDecimal somar = BigDecimal.valueOf(0);

		for (Items item : items) {

			somar = somar.add(item.subTotal());
		}

		BigDecimal valorTotal = object.getValorTotal();

		if (valorTotal.compareTo(somar) != 0) {
			throw new BusinessException("message.exception.valorTotal");

		}
	}
}
