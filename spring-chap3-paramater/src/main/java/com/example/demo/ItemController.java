package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

	@GetMapping("/")
	public String index() {
		return "itemForm";
	}

	@GetMapping("/item/hidden")
	public String itemFormHidden() {
		return "itemFormHidden";
	}

	//パスパラメーターだと商品所法をコントローラーに記載する
	@GetMapping("/item/{id}")
	public String show(@PathVariable("id") int id, Model model) {

		switch (id) {
		case 101:
			model.addAttribute("name", "ボールペン");
			model.addAttribute("price", 100);
			break;
		case 102:
			model.addAttribute("name", "消しゴム");
			model.addAttribute("price", 50);
			break;
		default:
			model.addAttribute("name", "未設定");
			model.addAttribute("price", 0);
			break;

		}

		return "itemConfirm";
	}

	@PostMapping("item")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "未設定") String name,
			@RequestParam(name = "price", defaultValue = "100") int price,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("price", price);

		return "itemConfirm";
	}

}
