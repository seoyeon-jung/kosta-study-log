package com.statement.condition;

public class IfPractice {

	public static void main(String[] args) {
		int score = (int) (Math.random() * 30) + 71; // 70~100가지의 숫자 중 랜덤 숫자 반환
		System.out.println("점수: " + score);

		String grade = "F";

		// 중접 if 문을 이용해서 문제를 풀 것
		// 바깥 if : 90점 이상은 A, 80점 이상은 B, 70점 이상은 C등급 부여
		// 중첩 if : 95, 85, 75점을 기준으로 등급에 +를 붙인다.

		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+";
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 85) {
				grade += "+";
			}
		} else if (score >= 70) {
			grade = "C";
			if (score >= 75) {
				grade += "+";
			}
		}

		// 다른 방법
//		if (score >= 90) {
//			if (score >= 95) {
//				grade = "A+";
//			} else {
//				grade = "A";
//			}
//		} else if (score >= 80) {
//			if (score >= 85) {
//				grade = "B+";
//			} else {
//				grade = "B";
//			}
//		} else if (score >= 70) {
//			if (score >= 75) {
//				grade = "C+";
//			} else {
//				grade = "C";
//			}
//		}
		//

		System.out.println("학점: " + grade);
	}

}
