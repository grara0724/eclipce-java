package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	//http://localhost:8080/msg=AAAのAAAをmessageに代入
	//Modelオブジェクトのにmodelという引数を渡し、addAttributeメソッドを使う
	public String hello(@RequestParam("msg") String message, Model model) {
		//（第一引数がthymeleafに渡す名前、第二引数が値となる）
		//memoにmessageの値を入れる
		model.addAttribute("memo", message);
		return "hello";
	}

	@PostMapping("/hello")
	public String helloByPost(@RequestParam("msg") String message, Model model) {
		model.addAttribute("memo", message);
		return "helloPost";
	}

}
