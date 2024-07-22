package com.collection.set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// TreeSet 컬렉션 생성 [int] 변수명 scores
		TreeSet<Integer> scores = new TreeSet<>();

		// 객체에 데이터를 저장
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);

		System.out.println(scores);
		// 오름차순 정렬 -> [75, 80, 87, 95, 98]

		System.out.println("가장 낮은 점수 : " + scores.first()); // 75
		System.out.println("가장 높은 점수 : " + scores.last()); // 98
		System.out.println("95점 아래 점수 : " + scores.lower(95)); // 87
		System.out.println("95점 윗 점수 : " + scores.higher(95)); // 98
		System.out.println("95점이거나 바로 아래 점수 : " + scores.floor(95)); // 95
		System.out.println("95점이거나 바로 위 점수 : " + scores.ceiling(95)); // 95

		// 내림차순으로 변경
		NavigableSet<Integer> descSet = scores.descendingSet();
		System.out.println(descSet); // [98, 95, 87, 80, 75]

		// 범위 검색 가능 (80점 이상 가져오기)
		NavigableSet<Integer> up80Set = scores.tailSet(80, true);
		System.out.println(up80Set);

		// 범위 검색 (80점 이상 90점 미만)
		NavigableSet<Integer> up80down90 = scores.subSet(80, true, 90, false);
		System.out.println(up80down90);

	}

}
