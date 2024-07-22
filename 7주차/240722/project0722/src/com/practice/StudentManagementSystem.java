package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentManagementSystem {
	// 필드
	// students 타입: List<Student> = new ArrayList<>();
	// studentIds 타입 : Set<String> = new HashSet<>();
	private List<Student> students = new ArrayList<>();
	private Set<String> studentIds = new HashSet<>();

	// 생성자 없음 (기본 생성자만 있음)
	public StudentManagementSystem() {
	}

	// 메서드
	// void addStudent (매개변수 - (String name, String id))
	// studentIds에 없는 id라면 Student 생성해서 추가하는 students에 추가 & studentIds에 추가
	public void addStudent(String name, String id) {
		if (!studentIds.contains(id)) {
			Student newStudent = new Student(name, id);
			students.add(newStudent);
			studentIds.add(id);
		} else {
			System.out.println("이미 존재하는 id입니다.");
		}
	}

	// void removeStudent 메소드 (String id)
	// 만약 students에 id가 같은 학생이 있으면 제거
	// studentIds에서도 제거
	public void removeStudent(String id) {
		for (Student student : students) {
			if (student.getId().equals(id)) {
				students.remove(student);
				studentIds.remove(id);
				return;
			}
		}
		System.out.println("제거할 수 없습니다.");
	}

	// void updateStudent 메소드 (String id, String newName, Map<String, Double> new
	// grade)
	// students 반복해서 만약 id가 같은 학생이 있으면, 해당 학생의 이름 변경,
	// 해당 학생의 이름 변경(setName), 점수 변경(updateGrade 메소드) 실행
	public void updateStudent(String id, String newName, Map<String, Double> newGrades) {
		for (Student student : students) {
			if (student.getId().equals(id)) {
				student.setName(newName);
				newGrades.forEach((subject, grade) -> student.updateGrade(subject, grade));
				return;
			}
		}
		System.out.println("학생 이름을 변경할 수 없습니다.");
	}

	// listStudents 메소드 ()
	// students 반복해서 모든 student 출력
	public void listStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	// listStudentGrades 출력 (String id)
	// students 반복해서 만약 id가 같은 학생이 있으면, 해당 학생 점수 출력
	void listStudentGrade(String id) {
		for (Student student : students) {
			if (student.getId().equals(id)) {
				// student.getGrades().forEach((k, v) -> System.out.println(k + " : " + v));
				System.out.println("id가 동일한 학생의 점수 : " + student.getGrades());
			}
		}
	}
}
