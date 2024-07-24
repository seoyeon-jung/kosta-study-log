package com.stream7;

import java.util.Arrays;
import java.util.List;

public class StreamFilterExample {

	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("우상혁", "황선우", "김우민", "서채현", "신유빈", "우상혁");

		// distinct로 중복된 요소가 제거
		nameList.stream().distinct().forEach(n -> System.out.print(n + ", "));
		System.out.println();

		// filter로 '우'가 들어간 이름만 출력
		nameList.stream().filter(n -> n.contains("우")).forEach(n -> System.out.print(n + ", "));
		System.out.println();

		// distnct로 중복된 요소가 제거되고, filter로 "우"가 들어간 이름만 출력
	}

}
