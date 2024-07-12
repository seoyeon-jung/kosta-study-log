package com.oop.basic.practice01;

public class StudentExample {

	public static void main(String[] args) {
		Student x = new Student("Kim", 100, 90, 95, 89);
		Student y = new Student("Lee", 60, 70, 99, 98);
		Student z = new Student("Park", 68, 86, 60, 40);

		System.out.println(x.name + ", 평균: " + x.getAvg() + ", 학점: " + x.getGrade());
		System.out.println(y.name + ", 평균: " + y.getAvg() + ", 학점: " + y.getGrade());
		System.out.println(z.name + ", 평균: " + z.getAvg() + ", 학점: " + z.getGrade());

	}

}
