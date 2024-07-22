package com.thread;

public class Task implements Runnable {

	@Override
	public void run() {
		// 작업 스레드가 처리할 코드
		for (int i = 1000; i > 0; i--) {
			System.out.println("스레드 " + i);
		}
	}

}
