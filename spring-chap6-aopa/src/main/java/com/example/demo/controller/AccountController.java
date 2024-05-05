package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

	@Autowired
	Account account;

	//ユーザ毎にセッションを分けるためセッションスコープを用意
	@Autowired
	HttpSession session;

	//初期表示
	@GetMapping("/")
	public String index() {
		session.invalidate();
		return "login";

	}

	@PostMapping("/login")
	public String login(
			@RequestParam("name") String name, Model model) {
		if (name.isEmpty()) {
			String message = "名前を入力してください";
			model.addAttribute("messege", message);
			return "login";
		}

		account.setName(name);
		return "input";
	}

}
