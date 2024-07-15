package com.oop.practice4;

public class Student {
	// 인스턴스 멤버 변수로 name, age, id
	private String name;
	private int age;
	private String id;

	// 정적 멤버 변수로 stduentCount를 정의합니다
	private static int studentCount = 0;

	// 생성자에서 학생 이름과 나이를 설정하고 ID를 생성합니다
	Student(String name, int age) {
		setName(name);
		this.age = age;
		this.id = generateId();
		studentCount++;
	}

	// getter 와 setter 메소드를 통해 멤버 변수에 접근합니다
	// setter => setName
	public void setName(String name) {
		this.name = name;
	}

	// getter => getName
	public String getName() {
		return name;
	}

	// 정적 메소드 getStudentCount 를 통해 생성한 학생 수를 반환합니다
	// getStudentCount
	public static int getStudentCount() {
		return studentCount;
	}

	// private 메소드 generateId를 통해 학생 ID를 생성합니다
	// generateId
	private String generateId() {
		return "S" + (1000 + studentCount);
	}

	// final 메소드 printStudentInfo를 통해 학생 정보를 출력합니다
	// printStudentInfo
	public final void printStudentInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("ID: " + id);
		System.out.println();
	}

}
