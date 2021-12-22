package com.order.domain.model;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "order")
public class Order {
	@Id
	private String id;
	private String idProduct;
	private String idOffer;
	private String description;
	private String theamount;
	private LocalDate instante;
}
