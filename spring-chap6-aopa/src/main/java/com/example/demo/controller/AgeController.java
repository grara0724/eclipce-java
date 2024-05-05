package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AgeController {

	@Autowired

	Account account;

	@PostMapping("/calcAge")
	public String calcAge(
			@RequestParam(name = "year", defaultValue = "2000") int year,
			@RequestParam(name = "month", defaultValue = "1") int month,
			@RequestParam(name = "day", defaultValue = "1") int day, Model model) {

		LocalDate birthday = LocalDate.of(year, month, day);
		account.setBirthday(birthday);
		return "result";
	}

}
