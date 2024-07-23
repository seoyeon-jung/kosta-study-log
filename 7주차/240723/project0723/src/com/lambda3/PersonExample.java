package com.lambda3;

public class PersonExample {

	public static void main(String[] args) {
		Person seoyeon = new Person("정서연", "학생", "대한민국");

		seoyeon.action1((name, job) -> {
			System.out.println("안녕하세요, 제 이름은 " + name + "입니다.");
			System.out.println("제 직업은 " + job + "입니다.");
		});

		seoyeon.action2(content -> {
			if (seoyeon.getNation().equals("대한민국")) {
				System.out.println("안녕하세요!");
			} else {
				System.out.println("Hello!");
			}
		});

	}

}
