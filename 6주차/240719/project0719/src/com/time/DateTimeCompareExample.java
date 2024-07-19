package com.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeCompareExample {

	public static void main(String[] args) {
		LocalDateTime start = LocalDateTime.of(2024, 7, 1, 0, 0, 0);
		LocalDateTime end = LocalDateTime.of(2024, 11, 11, 0, 0, 0);

		LocalDateTime now = LocalDateTime.now();

		if (now.isBefore(start)) {
			System.out.println("최인규를 만나기 전");
		} else if (now.isAfter(end)) {
			System.out.println("최인규와 헤어진 후");
		} else {
			System.out.println("최인규를 만나는 중");
			long remainDays = now.until(end, ChronoUnit.DAYS);
			System.out.println("남은 날: " + remainDays);
		}

	}

}
