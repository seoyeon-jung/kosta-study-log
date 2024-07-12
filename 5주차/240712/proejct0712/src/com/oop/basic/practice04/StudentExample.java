package com.oop.basic.practice04;

public class StudentExample {

	public static void main(String[] args) {
		// Student 객체를 3개 생성하여 배열에 넣는다.
		Student s1 = new Student("홍길동", 25, 171, 81);
		Student s2 = new Student("한사람", 23, 183, 72);
		Student s3 = new Student("임걱정", 26, 175, 65);
		Student[] sArr = { s1, s2, s3 };

		System.out.println("name\t나이\t신장\t몸무게");
		// 배열의 객체 정보 모두 출력
		for (Student s : sArr) {
			System.out.println(s.name + "\t" + s.age + "\t" + s.height + "\t" + s.weight);
		}

		System.out.println();

		// 평균값은 소수점 3자리에서 반올림하여 2자리까지 표현
		// 반복문으로 합계 구하기
		int ageSum = 0;
		int heightSum = 0;
		int weightSum = 0;
		for (Student s : sArr) {
			ageSum += s.age;
			heightSum += s.height;
			weightSum += s.weight;
		}

		// 나이의 평균 출력
		double ageAvg = Math.round(((double) ageSum / 3) * 100) / 100.0;
		System.out.println("나이의 평균: " + ageAvg);

		// 신장의 평균
		double heightAvg = Math.round(((double) heightSum / 3) * 100) / 100.0;
		System.out.println("신장의 평균: " + heightAvg);

		// 몸무게의 평균
		double weightAvg = Math.round((((double) weightSum) / 3) * 100) / 100.0;
		System.out.println("몸무게의 평균: " + weightAvg);

	}

}
