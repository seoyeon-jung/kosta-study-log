package com.thread2;

public class ThreadStateExample {

	public static void main(String[] args) {
		// State : enum type (중첩 enum)
		// thread의 상태
		// NEW: 스레드가 생성된 후, start 전
		// RUNNABLE: start 후 실행 준비가 된 상태 (실행 중일 수도, 실행 대기일 수도 있음)
		// TERMINATED : 실행 종료
		Thread.State state;

		Thread thread = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 1000000000; i++) {
					// 아무 동작도 출력 X
				}
			}

		};

		state = thread.getState();
		System.out.println("스레드 상태1: " + state); // NEW

		thread.start();
		state = thread.getState();
		System.out.println("스레드 상태2: " + state); // RUNNABLE

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		state = thread.getState();
		System.out.println("스레드 상태3: " + state); // TERMINATED

	}

}
