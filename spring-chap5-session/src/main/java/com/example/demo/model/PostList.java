package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class PostList {
	private List<Post> posts = new ArrayList<>();

	public List<Post> getPosts() {
		return posts;
	}

}
