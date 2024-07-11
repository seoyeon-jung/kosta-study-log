package com.reference.string;

import java.util.Scanner;

public class StringPractice3 {

	public static void main(String[] args) {
		// Scanner 로 주민등록번호를 입력받아라 (991212-2001234)
		Scanner sc = new Scanner(System.in);

		String number;
		String[] numberArr;

		// 만약 자릿수가 맞지 않으면, 계속 입력받아라
		do {
			System.out.print("주민등록번호를 입력하세요: ");
			number = sc.nextLine();
			numberArr = number.split("");

			if (numberArr.length != 14) {
				System.out.println("주민등록번호 형식과 맞지 않습니다. -를 포함하여 14자리를 입력해주세요.");
			}
		} while (numberArr.length != 14);

		// - 제외하고 숫자 가져오기(-로 인해 생기는 오류 방지)
		String pureNumber = number.replaceAll("-", "");

		// 자릿수가 잘 맞다면, 생년월일을 이용해서
		// 태어난 달 가져오기
		String month = pureNumber.substring(2, 4);
		String season = null;

		// 태어난 달이 3~5월이면 "봄", 6~8월이면 "여름", 9~11월이면 "가을", 12~2월 "겨울" 출력
//		if (month == "3" || month == "4" || month == "5") {
//			season = "봄";
//		} else if (month == "6" || month == "7" || month == "8") {
//			season = "여름";
//		} else if (month == "9" || month == "10" || month == "11") {
//			season = "가을";
//		} else {
//			season = "겨울";
//		}
		// switch 문으로 변경
		switch (month) {
		case "3", "4", "5" -> season = "봄";
		case "6", "7", "8" -> season = "여름";
		case "9", "10", "11" -> season = "가을";
		default -> season = "겨울";
		}

		// 성별 가져오기
		String genderStr = pureNumber.substring(6, 7);
		int genderNum = Integer.parseInt(genderStr);
		String gender;

		// 성별도 출력
//		if (genderNum == 2) {
//			gender = "여자";
//		} else {
//			gender = "남자";
//		}
		gender = genderNum % 2 == 0 ? "여자" : "남자";

		// 연도 가져오기
		String num_year = pureNumber.substring(0, 2);
		// int num_year_int = Integer.parseInt(num_year);
		// String year;

		// 연도가 00~24 => 20xx로 변경 / 나머지는 19xx
//		if (num_year_int >= 00 && num_year_int <= 24) {
//			year = "20" + num_year_int;
//		} else {
//			year = "19" + num_year_int;
//		}
		// String year = num_year_int <= 24 ? "20" + num_year_int : "19" + num_year_int;

		// 성별 코드가 3이상이면 2000년대생, 아니면 190년대생으로 연도 계산
		String year = genderNum >= 3 ? "20" + num_year : "19" + num_year;

		// 출력 예시: 1999 - 봄 - 여자
		System.out.println(year + " - " + season + " - " + gender);

		sc.close();

	}

}
