package com.oop.practice4;

public class Student_work {
	String name;
	int age;
	String id;

	static int studentCount;

	public Student_work(String name, int age) {
		setName(name);
		setAge(age);
		this.id = generateId();
		studentCount++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static int getStudentCount() {
		return studentCount;
	}

	private String generateId() {
		return "S" + (1000 + studentCount);
	}

	final void printStudentInfo() {
		System.out.println("ID: " + id + "\t Name: " + name + "\t Age: " + age);
	}
}
