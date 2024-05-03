package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RSPResult;

@Controller
public class RPSController {

	@Autowired
	RSPResult result;

	@GetMapping("/RSP")
	public String index() {
		return "RSP";
	}

	@PostMapping("/RSP")
	public String RSPMethod(
			@RequestParam("myHand") int myHand,
			Model model) {
		String[] RSPresults = result.RSPMethod(myHand);
		String gameResult = RSPresults[0];
		String comHand = RSPresults[1];
		model.addAttribute("result", gameResult);
		model.addAttribute("comHand", comHand);
		model.addAttribute("myHand", myHand);
		return "RSP";
	}

}
