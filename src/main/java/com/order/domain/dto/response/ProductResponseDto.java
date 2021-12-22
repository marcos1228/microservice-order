package com.order.domain.dto.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class ProductResponseDto {
	@ApiModelProperty(value = "id do produto", example = "123")
	private Long id;
	@ApiModelProperty(value = "nome do produto", example = "Dorflex")
	private String name;
	@ApiModelProperty(value = "descrição do produto", example = "Remédio para dor de cabeça")
	private String description;
	@ApiModelProperty(value = "preço do produto", example = "10")
	private BigDecimal price;
	@ApiModelProperty(value = "quantidade do produto", example = "10")
	private BigDecimal theamount;
	@ApiModelProperty(value = "categoria do produto", example = "medicamento")
	private String category;
	@ApiModelProperty(value = "classificação do produto", example = "generico")
	private String classification;
}
