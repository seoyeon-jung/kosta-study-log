package com.oop.basic;

public class Korean {
	static String nation = "Korea";
	String name, gender;
	int birthYear, birthMonth, birthDay;

	public Korean(String name, String number) {
		this.name = name;

//		if(number.charAt(7) == '1' || number.charAt(7) == '3') {
//			this.gender = "남자";
//		} else if (number.charAt(7) == '2' || number.charAt(7) ==  '4') {
//			this.gender = "여자";
//		}

		int genderCode = Integer.parseInt(number.substring(7, 8));
		if (genderCode % 2 == 0) {
			this.gender = "여자";
		} else {
			this.gender = "남자";
		}

		int year = Integer.parseInt(number.substring(0, 2));
		this.birthYear = 1000 + year;
		if (genderCode >= 3) {
			this.birthYear = 2000 + year;
		}

		this.birthYear = Integer.parseInt(number.substring(0, 2));
		this.birthMonth = Integer.parseInt(number.substring(2, 4));
		this.birthDay = Integer.parseInt(number.substring(4, 6));

		// this.birthYear += (this.birthYear <= 23) ? 2000 : 1900;
	}

}
