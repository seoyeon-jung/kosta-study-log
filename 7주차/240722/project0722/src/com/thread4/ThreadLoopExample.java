package com.thread4;

public class ThreadLoopExample {

	public static void main(String[] args) {
		ThreadLoop thread0 = new ThreadLoop();
		ThreadLoop thread1 = new ThreadLoop();

		thread0.setName("첫번째 스레드");
		thread1.setName("두번째 스레드");

		thread0.start();
		thread1.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread0.work = false;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread0.work = true;
	}

}
