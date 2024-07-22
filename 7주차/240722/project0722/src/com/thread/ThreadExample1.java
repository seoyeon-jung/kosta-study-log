package com.thread;

public class ThreadExample1 {

	public static void main(String[] args) {
		// Thread thread = new Thread(Runnable 인터페이스);
		// Thread thread = new Thread(new Task());

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 10; i > 0; i--) {
					System.out.println("스레드 " + i);
					try {
						// thread를 일시정지 시키는 것
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		// 해당 스레드를 시작시킨다.
		thread.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("메인 " + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
