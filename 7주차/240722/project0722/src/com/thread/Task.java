package com.thread;

public class Task implements Runnable {

	@Override
	public void run() {
		// 작업 스레드가 처리할 코드 작성
		for (int i = 10; i > 0; i--) {
			System.out.println("스레드 " + i);
		}

	}

}
