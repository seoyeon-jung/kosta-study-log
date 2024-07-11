package com.reference.list;

public class ListPractice3 {

	public static void main(String[] args) {
		String[] subjects = { "HTML", "CSS", "JavaScript", "Java", "CS" };

		// 향상된 for 문
		// 반복하면서 Java 라는 글자가 있으면 출력하고 없으면 넘어가자
		for (String subject : subjects) {
//			if (subject.contains("Java")) {
//				System.out.println(subject);
//			}

			if (subject.indexOf("Java") < 0) {
				continue;
			}
			System.out.println(subject);
		}
	}

}
