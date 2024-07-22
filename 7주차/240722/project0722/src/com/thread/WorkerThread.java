package com.thread;

public class WorkerThread extends Thread {

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

}
