package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

// public interfacae [Repository名] extends JpaRepository<[Entity], [EntiryのIdの型]>
public interface ItemRepository extends JpaRepository<Item, Integer> {
	//カテゴリーIDによる検索
	//SELECT : FROM items WHERE category_id=?
	List<Item> findByCategoryId(Integer categoryId);
}