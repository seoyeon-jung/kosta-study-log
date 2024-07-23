package com.collection.map;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		// 문자열 키와 정수 값을 갖는 TreeMap 생성
		TreeMap<String, Integer> treeMap = new TreeMap<>();

		// 엔트리 저장
		treeMap.put("오예스", 2000);
		treeMap.put("크리스피 포테이토", 200);
		treeMap.put("빠다코코넛", 1400);
		treeMap.put("단백질음료", 3000);
		treeMap.put("조청유과", 10000);
		treeMap.put("가나초콜릿", 5000);

		System.out.println(treeMap); // ㄱㄴㄷ순으로 출력

		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println();

		Entry<String, Integer> firstEntry = treeMap.firstEntry();
		System.out.println(firstEntry.getKey() + " : " + firstEntry.getValue());
		// 가나초콜릿 : 5000
		System.out.println();

		Entry<String, Integer> lastEntry = treeMap.lastEntry();
		System.out.println(lastEntry.getKey() + " : " + lastEntry.getValue());
		// 크리스피 포테이토 : 200
		System.out.println();

		Entry<String, Integer> lowerOhYesEntry = treeMap.lowerEntry("오예스");
		System.out.println(lowerOhYesEntry.getKey() + " : " + lowerOhYesEntry.getValue());
		// 빠다코코넛 : 1400
		System.out.println();

		// 내림차순 정렬
		NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
		Set<Entry<String, Integer>> decendingEntrySet = descendingMap.entrySet();
		for (Entry<String, Integer> entry : decendingEntrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println();

		System.out.println("가~자 까지 범위 검색");
		NavigableMap<String, Integer> fromGaToMaMap = treeMap.subMap("가", true, "자", true);
		System.out.println(fromGaToMaMap);
		// {가나초콜릿=5000, 단백질음료=3000, 빠다코코넛=1400, 오예스=2000}

	}

}
