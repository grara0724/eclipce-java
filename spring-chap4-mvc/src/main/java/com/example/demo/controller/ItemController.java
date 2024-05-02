package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Item;

@Controller
public class ItemController {

	@GetMapping("/item")
	public String index() {
		return "item";
	}

	@PostMapping("/item")
	public String add(
			@RequestParam("name") String name,
			@RequestParam("price") Integer price,
			Model model) {

		Item item = new Item(name, price);

		model.addAttribute("item", item);

		return "item";
	}

}
