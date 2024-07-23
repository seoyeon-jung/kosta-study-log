package com.collection.stack;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();

		coinBox.push(new Coin(500));
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(10));
		coinBox.push(new Coin(5));
		coinBox.push(new Coin(1));

		while (!coinBox.isEmpty()) {
			// Coin c = coinBox.peek(); // 안 꺼내고 계속 보는 거 -> 무한 루프
			Coin c = coinBox.pop();
			System.out.println("꺼낸 동전 : " + c.getValue());
			// 1 5 10 50 100 500 순서대로 출력
		}

	}

}
