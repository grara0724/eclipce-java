package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
	private final static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	private LocalDateTime createdAt;
	private String title;
	private String content;

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.createdAt = LocalDateTime.now();
	}

	public String getCreatedAt() {
		return createdAt.format(FMT);
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content.replaceAll("\n", "<br>");
	}

}
