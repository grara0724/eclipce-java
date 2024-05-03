package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@GetMapping({ "/", "logout" })
	public String index() {
		session.invalidate();
		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam("name") String name) {
		account.setName(name);
		return "blog";
	}

}
