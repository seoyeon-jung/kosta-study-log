package com.stream4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionExample2 {
	public static void main(String[] args) {
		List<Beverage> bList = new ArrayList<>();
		bList.add(new Beverage("따뜻한 아메리카노", 1500, false));
		bList.add(new Beverage("따뜻한 바닐라 라떼", 3500, false));
		bList.add(new Beverage("핫초코", 3500, false));
		bList.add(new Beverage("제로 콜라", 2000, true));
		bList.add(new Beverage("솔의눈", 2000, true));
		bList.add(new Beverage("실론티", 2000, true));

		// 상품명과 ice인지 아닌지
		Map<String, Boolean> list1 = bList.stream().collect(Collectors.toMap(b -> b.getName(), b -> b.isIce()));
		System.out.println(list1);

		System.out.println();

		// ice는 ice끼리, hot은 hot끼리 그룹핑
		Map<Boolean, List<Beverage>> isIceMap = bList.stream().collect(Collectors.groupingBy(b -> b.isIce()));
		for (Map.Entry<Boolean, List<Beverage>> entry : isIceMap.entrySet()) {
			System.out.println(entry.getKey() + " : ");
			for (Beverage b : entry.getValue()) {
				System.out.println("\t" + b);
			}
		}

		List<Beverage> iceList = isIceMap.get(true);
		List<Beverage> hotList = isIceMap.get(false);

		System.out.println();
		System.out.println(iceList);
		System.out.println(hotList);

		System.out.println();

		Map<Boolean, Double> isIceAvgPriceMap = bList.stream()
				.collect(Collectors.groupingBy(b -> b.isIce(), Collectors.averagingDouble(b -> b.getPrice())));
		System.out.println(isIceAvgPriceMap);

	}
}
