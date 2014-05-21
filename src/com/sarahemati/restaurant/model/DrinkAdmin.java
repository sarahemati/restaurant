package com.sarahemati.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sarahemati.restaurant.model.abstracts.BaseEntity;
import com.sarahemati.restaurant.model.enums.DrinkKind;

@Entity
@Table(name = "DRINKS")
// @NamedQueries(@NamedQuery(name="",query=""))
public class DrinkAdmin extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "PRICE")
	private Long price;

	@Enumerated(EnumType.STRING)
	@Column(name = "KIND")
	private DrinkKind kind;

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public DrinkKind getKind() {
		return kind;
	}

	public void setKind(DrinkKind kind) {
		this.kind = kind;
	}

}
