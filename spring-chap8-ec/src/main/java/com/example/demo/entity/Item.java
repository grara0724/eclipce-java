package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "category_id")
	private Integer categoryId;
	private String name;
	private Integer price;
	@Transient
	private Integer quantinty;

	public Integer getQuantinty() {
		return quantinty;
	}

	public void setQuantinty(Integer quantinty) {
		this.quantinty = quantinty;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCategory_id() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

}
