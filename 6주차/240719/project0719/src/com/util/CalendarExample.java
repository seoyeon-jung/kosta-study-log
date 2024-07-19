package com.util;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DAY_OF_MONTH);
		int weekInt = today.get(Calendar.DAY_OF_WEEK);
		int amPmInt = today.get(Calendar.AM_PM);

		String week = null;
		// switch 문으로 요일 가져오기
		switch (weekInt) {
		case 1:
			week = "일";
			break;
		case 2:
			week = "월";
			break;
		case 3:
			week = "화";
			break;
		case 4:
			week = "수";
			break;
		case 5:
			week = "목";
			break;
		case 6:
			week = "금";
			break;
		case 7:
			week = "토";
			break;
		}

		String amPm = amPmInt == 1 ? "오후" : "오전";
		// 조건문으로 "오전" 또는 "오후" 가져오기

		System.out.println(year + "년 " + month + "월 " + day + "일 " + week + "요일 " + amPm);

	}

}
