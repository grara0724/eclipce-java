package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {

	public List<String> generate(int charLength, int generateNum, int randomStyle) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < generateNum; i++) {
			if (randomStyle == 1) {
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else if (randomStyle == 2) {
				list.add(RandomStringUtils.randomNumeric(charLength));
			} else {
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			}
		}
		return list;
	}
}
