package com.generic;

public class BoxExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		box1.content = "안녕하세요";
		String data1 = box1.content;

		Box<Integer> box2 = new Box<>();
		box2.content = 10;
		int data2 = box2.content;

		Box<Member> box3 = new Box<>();
		box3.content = new Member("정서연", 20);
		Member data3 = box3.content;

		// Object text = "안녕하세요";
		// Object text = new String("안녕하세요");
		// box.content = "안녕하세요";

		// Integer i = 10;
		// Object number = 10;
		// box.content = 10;

		// box.content = new Member("최인규", 20);
	}
}
