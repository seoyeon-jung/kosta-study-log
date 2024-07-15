package com.oop.inheritance;

public class InheritanceExample {

	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println(parent.eyeColor); // 갈색
		parent.walk(); // 뒤뚱뒤뚱

		System.out.println();

		Child child = new Child();
		System.out.println(child.job); // 개발자
		child.Hello(); // 안녕하세요
		System.out.println(child.eyeColor); // 갈색
		child.walk(); // 뒤뚱뒤뚱 => 오버라이딩 후 "뚜벅뚜벅" 출력

	}

}
