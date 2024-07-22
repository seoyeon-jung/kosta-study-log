package com.collection.list;

import java.util.ArrayList;

public class ArrayListExample1 {
	public static void main(String[] args) {
		// 문자열만 들어가는 ArrayList 생성
		ArrayList<String> list = new ArrayList<>();

		list.add("apple");
		list.add("banana");
		list.add("cherry");

		// ArrayList 전체 요소 출력
		System.out.println("초기화된 ArrayList: " + list); // [apple, banana, cherry]

		// ArrayList에서 특정 요소 제거
		list.remove("banana");
		System.out.println("바나나 삭제된 ArrayList: " + list); // [apple, cherry]

		// ArrayList에서 특정 위치 요소 제거
		list.remove(0);
		System.out.println("0번재 요소가 삭제된 ArrayList: " + list); // [cherry]

		// ArrayList에 요소 추가
		list.add("durian");
		System.out.println("맨 뒤에 두리안이 추가된 ArrayList: " + list); // [cherry, durian]

		// 원하는 위치에 요소 추가
		list.add(0, "blueberry");
		System.out.println("0번째에 블루베리가 추가된 ArrayList: " + list); // [blueberry, cherry, durian]

		// ArrayList에서 특정 위치 요소 수정
		list.set(1, "cacao");
		System.out.println("체리가 카카오로 수정된 ArrayList: " + list); // [blueberry, cacao, durian]

		// 찾는 요소가 있는지 여부
		boolean containsCacao = list.contains("cacao");
		System.out.println("카카오가 arrayList에 있는지 : " + containsCacao); // true

		// ArrayList 크기 구하기
		int size = list.size();
		System.out.println("현재 arrayList의 길이 : " + size); // 3

		// 반복문 돌리기
//		for(int i = 0; i < list.size(); i++) {
//			String item = list.get(i);
//		}
		for (String item : list) {
			System.out.println(item);
		}

		// ArrayList 전체 삭제
		list.clear();
		System.out.println("텅 빈 ArrayList: " + list); // []

	}
}
