package com.stream4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionExample {
	public static void main(String[] args) {
		List<Beverage> bList = new ArrayList<>();
		bList.add(new Beverage("아이스 아메리카노", 1500, true));
		bList.add(new Beverage("따뜻한 바닐라 라떼", 3500, false));
		bList.add(new Beverage("제로 콜라", 2000, true));
		bList.add(new Beverage("솔의눈", 2000, true));
		bList.add(new Beverage("실론티", 2000, true));
		bList.add(new Beverage("실론티", 2000, true));

		// 2000원짜리 리스트
		List<Beverage> two$List = bList.stream().filter(b -> b.getPrice() == 2000) // Stream<Beverage>
				.collect(Collectors.toList());
		// .toList()만 쓸 수도 있다
		System.out.println(two$List);

		System.out.println();

		// 음료수 이름이 3글자인 것
		Set<Beverage> threeSet = bList.stream().filter(b -> b.getName().length() == 3).collect(Collectors.toSet());
		System.out.println(threeSet);
		// 실눈티가 하나만 나온다 (set이므로 중복 x)
		System.out.println();

		// 음료 이름과 가격으로만 구성되어있는 Map 만들기
		/// toMap() -> 두 개의 매개변수 필요 (키와 값)
		Map<String, Integer> iceMap = bList.stream().distinct().filter(b -> b.isIce())
				.collect(Collectors.toMap(b -> b.getName(), b -> b.getPrice()));
		System.out.println(iceMap);
	}
}
