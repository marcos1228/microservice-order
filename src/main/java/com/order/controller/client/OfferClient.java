package com.order.controller.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.domain.dto.response.OfferResponseDto;



@FeignClient(name = "${offer.name}", url = "${offer.url}")
public interface OfferClient {

	@PostMapping("${offer.getbyid}")
	public List<Long> getByOffer(@RequestBody List<Long> idOffer);
}
