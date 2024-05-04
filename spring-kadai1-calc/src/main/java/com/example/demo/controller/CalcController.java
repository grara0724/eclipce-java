package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	@GetMapping("/calc")
	public String index() {
		return "calcView";
	}

	@GetMapping("/add_num")
	public String add_num(
			@RequestParam("num1") Integer num1,
			@RequestParam("num2") Integer num2,
			Model model) {
		Integer sum = num1 + num2;
		model.addAttribute("sum", sum);
		return "calcView";

	}

}
