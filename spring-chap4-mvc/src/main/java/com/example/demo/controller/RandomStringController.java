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

	//		データの受け渡しをする
	@PostMapping("/random")
	public String generate(
			//random.htmlから送られてきた値を受け取ってserviceクラスで処理する役割
			@RequestParam("charLength") int charLength,
			@RequestParam("generateNum") int generateNum,

			//ここを@RequestParam("randomStyle") int randomStyle,にすると400エラーのリクエストパラメータ不足になる
			@RequestParam(name = "randomStyle", defaultValue = "1") int randomStyle,
			Model model) {

		List<String> list = service.generate(charLength, generateNum, randomStyle);
		//そうして作られたlistをrandListとしてrandom.html渡す
		model.addAttribute("randList", list);

		return "random";
	}

}
