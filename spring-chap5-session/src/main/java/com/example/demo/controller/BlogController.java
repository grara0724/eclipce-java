package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			@RequestParam("name") String name,
			Model model) {
		if ("田中太郎".equals(name) || "鈴木一郎".equals(name)) {
			account.setName(name);
			return "blog";
		} else {
			model.addAttribute("boolean", true);
			return "login";
		}
	}

	@PostMapping("/blog")
	public String posts(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam(name = "feeling", defaultValue = "") String feeling,
			Model model) {

		if (content.equals("") || title.equals("")) {
			model.addAttribute("boolean", true);
			return "blog";
		} else {
			if (content.indexOf("http") != -1) {
				StringBuilder sb = new StringBuilder(content);
				sb.insert(sb.indexOf("http"), "<a\t	href=\"");
				sb.append("\">");
				sb.append(content);
				sb.append("</a>");
				content = sb.toString();
			}
			List<Post> allPosts = postList.getPosts();
			allPosts.add(new Post(title, content, feeling));
			return "blog";
		}

	}
}
