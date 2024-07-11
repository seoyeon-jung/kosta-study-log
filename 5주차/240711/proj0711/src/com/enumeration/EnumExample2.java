package com.enumeration;

import java.util.Calendar;

public class EnumExample2 {
	public static void main(String[] args) {
		// Calendar 클래스 사용
		Calendar now = Calendar.getInstance(); // 현재 시간 가져오기

		int year = now.get(Calendar.YEAR);
		System.out.println(year + "년");

		// 월(0~11) => +1을 해야 제대로 월을 알 수 있다
		int month = now.get(Calendar.MONTH) + 1;
		System.out.println(month + "월");

		int day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(day + "일");

		// 1~7 요일 (1: 일요일)
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(week + "요일");

		// 0~23시
		int hour = now.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour + "시");

		int minute = now.get(Calendar.MINUTE);
		System.out.println(minute + "분");

		int second = now.get(Calendar.SECOND);
		System.out.println(second + "초");
	}
}
