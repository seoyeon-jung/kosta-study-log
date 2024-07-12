package com.oop.basic.ch01;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student(); // 생성자
		System.out.println("변수 s1은 Student 객체를 참조합니다.");

		Student s2 = new Student();
		System.out.println("변수 s2는 또 다른 Student 객체로 참조합니다.");

	}

}
