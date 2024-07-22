package com.collection.list;

import java.util.Vector;

public class VectorExample1 {

	public static void main(String[] args) {
		// ArrayList 생성 [int]
		Vector<Integer> list = new Vector<>();

		// 첫번째 스레드 정의 [0부터 49까지 넣는 역할]
		Thread thread0 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					list.add(i);
					System.out.println("Thread-0에 " + i + " 추가됨");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		});

		// 두번째 스레드 정의 [50부터 99가지 넣는 역할]
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 50; i < 100; i++) {
					list.add(i);
					System.out.println("Thread-1에 " + i + " 추가됨");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		});

		thread0.start();
		thread1.start();

		try {
			thread0.join();
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("총 길이 : " + list.size());
		System.out.println(list);

		// 같은 객체에 두 개의 스레드가 접근 중이므로 순서대로 정렬되지 않음
		// 길이가 제대로 나옴

	}

}
