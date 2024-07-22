package com.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample2 {
	public static void main(String[] args) {
		// HashSet 컬렉션 객체 생성 [Member]
		Set<Member> set = new HashSet<>();

		// 정서연 25살 객체 저장 x2
		set.add(new Member("정서연", 25));
		set.add(new Member("정서연", 25));

		// 저장된 객체 수 출력
		System.out.println("저장된 객체 수 : " + set.size());
		// 저장된 객체 수 : 2
		// 어노테이션 안 쓰고 생성자 사용했더니 다른 객체로 나옴
		// 롬복 사용 시 저장된 객체 수 : 1 (중복은 저장하지 않음)
	}
}
