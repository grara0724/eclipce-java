package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/")
	public String index(Model model) {
		List<Item> itemList = itemRepository.findAll();
		model.addAttribute("items", itemList);
		return "items";
	}

	@GetMapping("/items")
	public String items(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "sort", defaultValue = "") String sort,
			Model model) {
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		List<Item> itemList = null;
		if (categoryId == null && sort.isEmpty()) {
			itemList = itemRepository.findAll();
		} else if (categoryId == null && sort.equals("asc")) {
			itemList = itemRepository.findAllByOrderByPriceAsc();
		} else if (categoryId == null && sort.equals("desc")) {
			itemList = itemRepository.findAllByOrderByPriceDesc();
		} else if (categoryId != null && sort.isEmpty()) {
			itemList = itemRepository.findByCategoryId(categoryId);
		} else if (categoryId != null && sort.equals("asc")) {
			itemList = itemRepository.findByCategoryIdOrderByPriceAsc(categoryId);
		} else if (categoryId != null && sort.equals("desc")) {
			itemList = itemRepository.findByCategoryIdOrderByPriceDesc(categoryId);
		}
		model.addAttribute("items", itemList);
		return "items";
	}

	@GetMapping("/items/search")
	public String search(
			@RequestParam(name = "name", defaultValue = "") String name,
			Model model) {
		List<String> errorList = new ArrayList<>();
		List<Item> itemList = itemRepository.findByNameContaining(name);

		if (name.isEmpty()) {
			errorList.add("検索したい商品名を入力してください");
		}

		if (itemList.size() == 0) {
			errorList.add("商品名に一致するものはございませんでした");
		}
		if (errorList.size() > 0) {

			itemList = itemRepository.findAll();
			model.addAttribute("memos", errorList);
			model.addAttribute("items", itemList);
			return "items";
		}
		model.addAttribute("items", itemList);
		return "items";
	}

	@GetMapping("/items/add")
	public String create() {
		return "addItem";
	}

	@GetMapping("/items/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {

		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		return "editItem";
	}

	@PostMapping("items/add")
	public String store(
			@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "price", defaultValue = "0") Integer price,
			Model model) {

		List<String> errorList = new ArrayList<>();
		if (categoryId > 3 || categoryId < 1) {
			errorList.add("正しい商品IDを入力してください");
		}
		if (name.isEmpty()) {
			errorList.add("商品の名前を入力してください");
		}
		if (price <= 0) {
			errorList.add("正しい商品の値段を入力してください");
		}
		if (errorList.size() > 0) {
			model.addAttribute("memos", errorList);
			return "addItem";
		}

		//itemオブジェクトの生成
		Item item = new Item(categoryId, name, price);
		//itemsテーブルへの反映
		itemRepository.save(item);
		//「/items」にGETでリクエストしなおす
		return "redirect:/items";

	}

	@PostMapping("items/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "price", defaultValue = "0") Integer price,
			Model model) {

		List<String> errorList = new ArrayList<>();
		if (categoryId > 3 || categoryId < 1) {
			errorList.add("正しい商品IDを入力してください");
		}
		if (name.isEmpty()) {
			errorList.add("商品の名前を入力してください");
		}
		if (price <= 0) {
			errorList.add("正しい商品の値段を入力してください");
		}
		if (errorList.size() > 0) {
			model.addAttribute("memos", errorList);
			Item item = itemRepository.findById(id).get();
			model.addAttribute("item", item);
			return "editItem";
		}

		//itemオブジェクトの生成
		Item item = new Item(id, categoryId, name, price);
		//itemsテーブルへの反映
		itemRepository.save(item);
		//「/items」にGETでリクエストしなおす
		return "redirect:/items";

	}

	@PostMapping("items/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id, Model model) {
		itemRepository.deleteById(id);
		return "redirect:/items";

	}

}
