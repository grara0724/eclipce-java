package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Post;
import com.example.demo.model.PostList;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	PostList postList;

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

	@PostMapping("/blog")
	public String posts(
			@RequestParam("title") String title,
			@RequestParam("content") String content) {

		List<Post> allPosts = postList.getPosts();

		allPosts.add(new Post(title, content));
		return "blog";
	}

}
