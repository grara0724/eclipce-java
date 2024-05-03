package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {
	private final static int GENERATE_NUM = 10;

	public List<String> generate(int charLength, boolean withNumber) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < GENERATE_NUM; i++) {
			if (withNumber) {
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else {
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			}
		}
		return list;
	}
}
