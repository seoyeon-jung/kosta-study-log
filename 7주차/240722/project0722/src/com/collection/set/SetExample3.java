package com.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample3 {
	public static void main(String[] args) {
		Set<String> cookies = new HashSet<>();

		cookies.add("맛동산");
		cookies.add("새우깡");
		cookies.add("허니버터칩");
		cookies.add("꼬북칩");
		cookies.add("초코하임");

//		for (String cookie : cookies) {
//			System.out.println(cookie);
//		}

		// Iterator = 반복해주는 기계
		Iterator<String> iterator = cookies.iterator();

		while (iterator.hasNext()) {
			// 안에 하나라도 있는지 확인
			String cookie = iterator.next(); // 다음꺼 가져오기
			System.out.println(cookie);
		}
	}
}
