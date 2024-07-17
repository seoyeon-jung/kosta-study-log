package com.nested.class2;

// 학교 시스템 모델링
// School 클래스 내부에는 Student 클래스가 중첩되어 있다
// 각 학교마다 여러 학생들을 가지고 있으며, 객체의 학생은 이름과 성적을 가지고 있다.
// 최대 학생 수는 13명이다.

public class School {
	// 학교 관련 데이터(필드)
	private String name;
	private Student[] students;
	private int studentCount;

	// 생성자 (학교 객체를 생성할 때 사용)
	public School(String name) {
		this.name = name;
		this.students = new Student[13]; // 최대 학생 수 13명
		this.studentCount = 0; // 초기 학생 수 0명
	}

	// students 학생 추가하는 메소드 (학교 관련 동작)
	public void addStudent(String studentName, int grade) {
		if (studentCount < students.length) {
			students[studentCount] = new Student(studentName, grade);
			studentCount++;
		} else {
			System.out.println("정원 초과");
		}
	}

	// 전체 학생 정보를 출력하는 메소드 (학교 관련 동작)
	public void printSutdents() {
		for (int i = 0; i < studentCount; i++) {
			System.out.println(students[i]);
		}
	}

	// 학생 평균 점수를 반환하는 메소드 (학교 관련 동작)
	public double calcAvgGrade() {
		if (studentCount == 0) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < studentCount; i++) {
			sum += students[i].getGrade();
		}
		return (double) sum / studentCount;
	}

	// 중첩 클래스 (각 학생은 이름과 성적을 가짐)
	private class Student {
		// 학생 관련 데이터(필드)
		private String name;
		private int grade;

		// 생성자 (학생 객체를 생성할 때 사용)
		public Student(String name, int grade) {
			this.name = name;
			this.grade = grade;
		}

		// getter
		public String getName() {
			return name;
		}

		public int getGrade() {
			return grade;
		}

		@Override
		public String toString() {
			return "name: " + getName() + ", grade: " + getGrade();
		}

	}

}
