package com.order.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class DeliveryAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String neighborhood;
	private String city;
	private String complements;
	private String addressDescription;
	private String cep;
	private Integer number;
	private String state;
	private String type;
	private String referencePoint;
	private String recipientName;
	private String recipientDocumentNumber;
	private String contactPhone;
}
