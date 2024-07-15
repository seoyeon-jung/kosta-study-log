package com.oop.practice4;

public class StudentExample {

	public static void main(String[] args) {
		// 학생 인스턴스 생성
		Student student1 = new Student("Alice", 20);
		Student student2 = new Student("Bob", 22);

		// 정보 출력
		student1.printStudentInfo();
		student2.printStudentInfo();

		// 정적 메소드 호출
		System.out.println("총 학생 수: " + Student.getStudentCount());

		// 접근자의 생성자 사용
		student1.setName("Alicia");
		System.out.println("변경된 이름: " + student1.getName());
	}

}
