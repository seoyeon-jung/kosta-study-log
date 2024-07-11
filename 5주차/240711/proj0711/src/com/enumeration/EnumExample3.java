package com.enumeration;

import java.util.Calendar;

public class EnumExample3 {
	public static void main(String[] args) {
		// Calendar 클래스 사용
		Calendar now = Calendar.getInstance();
		int week = now.get(Calendar.DAY_OF_WEEK);

		// 오늘의 요일을 출력하는 프로그램 구현
		Week today = null;

		today = switch (week) {
		case 1 -> Week.SUNDAY;
		case 2 -> Week.MONDAY;
		case 3 -> Week.TUESDAY;
		case 4 -> Week.WEDNESDAY;
		case 5 -> Week.THURSDAY;
		case 6 -> Week.FRIDAY;
		case 7 -> Week.SATURDAY;
		default -> null;
		};

		if (today == Week.SUNDAY) {
			System.out.println("쉬는 날입니다.");
		} else {
			System.out.println("열심히 공부하세요.");
		}
	}
}
