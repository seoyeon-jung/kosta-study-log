package com.statement.condition;

public class SwtichExample {

	public static void main(String[] args) {
		String id = "990101-1234567";
		// int genderNum = Integer.parseInt(id.subString(7, 8));
		int genderNum = id.charAt(7) - '0';

		switch (genderNum % 2) {
		case 0:
			System.out.println("여성입니다.");
			break;
		case 1:
			System.out.println("남성입니다.");
			break;
		}
	}

}
