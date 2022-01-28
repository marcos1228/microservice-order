package com.order.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TB_ORDER")
@Data
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idOffer;
	private LocalDate instante;
	private BigDecimal valorTotal;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "consumer_id")
	private Customer consumer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deliveryAddress_id")
	private DeliveryAddress deliveryAddress;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Items> items;
	
}
