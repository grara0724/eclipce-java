package com.example.demo.model;

public class Item {

	private String name;
	private Integer price;

	public Item(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

}
