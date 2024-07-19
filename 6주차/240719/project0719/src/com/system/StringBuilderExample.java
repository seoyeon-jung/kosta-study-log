package com.system;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("자바 공부가 재미 없어요");
		sb.insert(6, " 너무");
		sb.delete(12, 13);
		sb.replace(12, 13, "있");

		System.out.println(sb);
	}
}
