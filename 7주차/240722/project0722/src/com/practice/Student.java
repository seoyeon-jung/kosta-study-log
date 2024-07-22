package com.practice;

import java.util.HashMap;
import java.util.Map;

public class Student {
	// 필드
	// name과 id는 문자열
	// grades는 Map<String, Double>
	private String name, id;
	private Map<String, Double> grades;

	// 생성자(String name, String id)
	// 점수는 new HashMap() 사용
	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		this.grades = new HashMap<>();
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Double> getGrades() {
		return grades;
	}

	public void setGrades(Map<String, Double> grades) {
		this.grades = grades;
	}

	// toString
	@Override
	public String toString() {
		return "[이름: " + name + ", id: " + id + ", grades: " + grades + "]";
	}

	// updateGrade 메소드 (매개변수: String subject, Double grade)
	public void updateGrade(String subject, Double grade) {
		grades.put(subject, grade);
	}

}
