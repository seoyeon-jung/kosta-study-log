package com.stream10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {

	public static void main(String[] args) {
		List<String> msgList = new ArrayList<>();
		msgList.add("안녕? 난 최인규야");
		msgList.add("우리 같이 열심히 공부하자");
		msgList.add("서영훈님 보고 싶어요.");

		msgList.stream() // Stream<String>
				.flatMap(msg -> Arrays.stream(msg.split(" "))) /// Stream<String> 11개로 쪼개짐
				.forEach(word -> System.out.println(word));

		System.out.println();

		List<String> strNums = Arrays.asList("10, 20, 30", "40, 50", "60");
		strNums.stream() // Stream<String>
				.flatMapToInt(e -> {
					String[] strArr = e.split(","); // ["10", " 20", " 30"]
					int[] intArr = new int[strArr.length];
					for (int i = 0; i < strArr.length; i++) {
						intArr[i] = Integer.parseInt(strArr[i].trim());
					}
					return Arrays.stream(intArr);
				}) // IntStream
				.forEach(System.out::println);
		;
	}

}
