package com.order.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.order.domain.dto.response.OfferResponseDto;

import lombok.Data;

@Entity
@Table(name = "TB_ITEMS")
@Data
@JsonDeserialize(as = Items.class)
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idProduct;
	@Transient 
	@JsonProperty("idOffer")
	private List<Long> idOffer;

	private String name;

	private BigDecimal discount;

	private BigDecimal theamount;

	private BigDecimal price;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "item_pedido_fk", value = ConstraintMode.CONSTRAINT))
	private Order order;

	public BigDecimal subTotal() {
		return (price.subtract(discount)).multiply(theamount);
	}
}
