package com.thread3;

public class ThreadA extends Thread {
	@Override
	public void run() {
		Thread threadB = new ThreadB();
		threadB.start();
		try {
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 메소드 체이닝
		Thread.currentThread().setName("폴더 열기");
		String name = Thread.currentThread().getName();
		System.out.println(name + " 시작");
		System.out.println(threadB.getName() + "폴더를 엽니다");
		System.out.println(name + " 끝");
	}
}
