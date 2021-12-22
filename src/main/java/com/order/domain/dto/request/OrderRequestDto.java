package com.order.domain.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderRequestDto {
	@ApiModelProperty(value = "id do pedido", example = "123")
	private String id;
	@ApiModelProperty(value = "id do produto", example = "123")
	@NotNull(message = "{idProduct.notNull}")
	@NotBlank(message = "{idProduct.notBlank}")
	@NotEmpty(message = "{idProduct.notEmpty}")
	private String idProduct;
	@ApiModelProperty(value = "id da offer", example = "123")
	private String idOffer;
	@ApiModelProperty(value = "descrição do pedido", example = "luva")
	@NotNull(message = "{description.notNull}")
	@NotBlank(message = "{description.notBlank}")
	@NotEmpty(message = "{description.notEmpty}")
	private String description;
	@ApiModelProperty(value = "quantidade", example = "10")
	@NotNull(message = "{theamount.notNull}")
	@NotBlank(message = "{theamount.notBlank}")
	@NotEmpty(message = "{theamount.notEmpty}")
	private String theamount;
	private LocalDate instante;
}
