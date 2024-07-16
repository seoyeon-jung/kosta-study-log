package com.review;

public class Person {
	// 정적 멤버 변수
	private static int totalPersons = 0;

	// 인스턴스 멤버 변수
	private String name;
	private int age;

	// 생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		totalPersons++;
	}

	// 정적 메소드
	public static int getTotalPersons() {
		return totalPersons;
	}

	// 인스턴스 메소드
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		Person person1 = new Person("Alice", 30);
		Person person2 = new Person("Bob", 25);
		Person person3 = new Person("Charlie", 35);

		// 출력
		System.out.println("Total Persons: " + Person.getTotalPersons());
		System.out.println("Person1 Name: " + person1.getName());
		System.out.println("Person1 Age: " + person1.getAge());
		System.out.println("Person2 Name: " + person2.getName());
		System.out.println("Person2 Age: " + person2.getAge());

		// Person1의 나이 변경
		person1.setAge(31);
		System.out.println("Person1 New Age: " + person1.getAge());
	}
}