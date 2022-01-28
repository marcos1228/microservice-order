package com.order.domain.model;


import java.math.BigDecimal;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "TB_ITEMS")
@Data
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idProduct;
	private Long idOffer;
	private String name;
	private BigDecimal discount;
	private BigDecimal theamount;
	private BigDecimal price;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "item_pedido_fk", value = ConstraintMode.CONSTRAINT))
	private Order order;
	
	public BigDecimal subTotal() {
		return (price.subtract(discount)).multiply(theamount);
	}
}
