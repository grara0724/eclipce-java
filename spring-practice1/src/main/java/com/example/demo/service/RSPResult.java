package com.example.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RSPResult {

	public String[] RSPMethod(int myHand) {
		Random rand = new Random();
		Integer comHand = rand.nextInt(3);

		String result;
		if (myHand == comHand) {
			result = "引き分け";
		} else if ((myHand == 0 && comHand == 1) || (myHand == 1 && comHand == 2) || (myHand == 2 && comHand == 0)) {
			result = "勝ち";
		} else {
			result = "負け";
		}
		String[] RSPResult = { result, comHand.toString() };
		return RSPResult;

	}

}
