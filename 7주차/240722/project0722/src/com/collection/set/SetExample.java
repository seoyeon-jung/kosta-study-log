package com.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
		// HashSet 컬렉션 객체 생성
		Set<String> set = new HashSet<>();

		// 컬렉션 객체에 데이터 저장
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet");
		set.add("JSP");
		set.add("MyBatis");
		set.add("JPA");
		set.add("Java");

		System.out.println("저장된 요소의 개수 : " + set.size());
		System.out.println(set);
		// set는 순서 상관없이 출력된다
		// 중복저장하지도 않는다.
	}
}
