package com.order.controller.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.domain.dto.response.OfferResponseDto;

@FeignClient(name = "${offer.name}", url = "${offer.url}")
public interface OfferClient {
	@GetMapping("${offer.getbyid}")
	Optional<OfferResponseDto> getByOffer(@PathVariable("id") String id);
}
