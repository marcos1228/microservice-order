package com.order.controller.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.domain.dto.response.ProductResponseDto;

@FeignClient(name = "${product.name}", url = "${product.url}")
public interface ProductClient {

	@GetMapping(value = "${product.getbyid}")
	Optional<ProductResponseDto> getByProduct(@PathVariable("id") Long id);
}
