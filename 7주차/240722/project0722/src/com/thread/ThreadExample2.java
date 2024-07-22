package com.thread;

public class ThreadExample2 {

	public static void main(String[] args) {
		// Thread thread = new Thread의자식클래스();
		// Thread thread = new WorkerThread();

		// 익명 자식 객체를 통해 생성
		Thread thread = new Thread() {
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
		};

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
