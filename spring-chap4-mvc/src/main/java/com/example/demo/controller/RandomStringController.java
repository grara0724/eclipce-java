package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomStringService;

@Controller
public class RandomStringController {

	@Autowired
	RandomStringService service;

	@GetMapping("/random")
	public String index() {
		return "random";
	}

	//	データの受け渡しをする
	@PostMapping("/random")
	public String generate(
			//Randomhtmlから送られてきた値を受け取ってserviceクラスで処理する役割
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			Model model) {
		List<String> list = service.generate(charLength, withNumber);
		//そうして作られたlistをrandListとして渡す
		model.addAttribute("randList", list);

		return "random";
	}

}
