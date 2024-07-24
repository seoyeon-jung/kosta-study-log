package com.stream;

import java.util.Arrays;
import java.util.List;

public class PracticeExample {
	public static void main(String[] args) {
		// 샘플 상품들..
		Product mic = new Product("마이크");
		Product headSet = new Product("헤드셋");
		Product earPhone = new Product("이어폰");
		Product speaker = new Product("스피커");
		Product iPad = new Product("아이패드");
		Product monblancPen = new Product("몽블랑 펜");
		Product rolexWatch = new Product("롤렉스 시계");
		Product dubaiChoco = new Product("두바이 초콜릿");
		Product car = new Product("자동차");

		// 샘플데이터 만들기
		List<User> users = Arrays.asList(
				new User("민니",
						Arrays.asList(new Order(Arrays.asList(mic, headSet, earPhone, speaker)),
								new Order(Arrays.asList(iPad)), new Order(Arrays.asList(monblancPen)))),
				new User("우기", Arrays.asList(new Order(Arrays.asList(rolexWatch, dubaiChoco)),
						new Order(Arrays.asList(car)))));

		users.stream() // Stream<User>를 생성
				.flatMap(user -> user.getOrders().stream()) // -> flatMap으로 Stream<Order>로 변환
				.flatMap(order -> order.getProoducts().stream()) // -> flatMap으로 Stream<Product>로 변환
				.distinct().filter(product -> product.getName().length() > 3) // 이름 길이가 3이상인 product name 출력
				.forEach(System.out::println); // -> 각 상품이름을 출력

	}
}
