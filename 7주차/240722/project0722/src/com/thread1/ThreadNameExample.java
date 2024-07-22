package com.thread1;

public class ThreadNameExample {
	public static void main(String[] args) {
		// 1. Thread의 생성자 매개변수로 인터페이스 사용
		// 2. Thread의 자식 객체를 만들어 사용

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// 현재 해당되는 thread 가져오기
				Thread thread = Thread.currentThread();
				thread.setName("Upload");
				String threadName = thread.getName();
				for (int i = 0; i <= 100; i = i + 10) {
					try {
						Thread.sleep(600);
						System.out.println(threadName + ": " + i + "%");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// 현재 해당되는 thread 가져오기
				Thread thread = Thread.currentThread();
				thread.setName("download");
				String threadName = thread.getName();
				for (int i = 0; i <= 100; i = i + 10) {
					try {
						Thread.sleep(500);
						System.out.println(threadName + ": " + i + "%");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// 메인 thread 가져오기
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName()); // main

		thread1.start(); // Thread-0
		thread2.start(); // Thread-1
	}
}
