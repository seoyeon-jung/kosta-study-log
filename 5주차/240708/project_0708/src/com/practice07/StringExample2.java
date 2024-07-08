package com.practice07;

public class StringExample2 {
	public static void main(String[] args) {
		String str1 = "" + "{\n" + "\t\"id\":\"winter\",\n" + "\t\"name\":\"눈송이\",\n" + "}";
		System.out.println(str1);
		String str2 = """
				{
					"id": "winter",
					"name": "눈송이"
				}
				""";
		System.out.println(str2);
		String str3 = """
				나는 자바를 \
				학습합니다,
				나는 자바 고수가 될 겁니다.
				""";
		System.out.println(str3);
	}
}
