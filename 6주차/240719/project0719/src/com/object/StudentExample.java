package com.object;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		Student s3 = new Student(1, new String("홍길동"));

		System.out.println(s1.getName() == s2.getName()); // true
		System.out.println(s1.getName() == s3.getName()); // false

		System.out.println(s1.hashCode()); // 54150063
		System.out.println(s2.hashCode()); // 54150063
		System.out.println(s3.hashCode()); // 54150063
	}

}
