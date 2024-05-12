package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	//フィールド
	@Id //主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) //postgresqlでSERIAL型の値（自動採番1，2，3とじゅんばんになるやつ）であることを示す
	private Integer id;

	@Column(name = "category_id") //テーブルのカラム名が異なる場合(SQLではcategory_id表記だが、javaではcategoryId表記のため)
	private Integer categoryId;
	private String name;
	private Integer price;

	public Item() {
	};

	public Item(Integer categoryId, String name, Integer price) {
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	public Item(Integer id, Integer categoryId, String name, Integer price) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

}
