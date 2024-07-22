package com.thread4;

public class ThreadLoop extends Thread {
	public boolean work = true;

	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(Thread.currentThread().getName() + "의 작업처리");
			} else {
				Thread.yield();
			}
		}
	}

}
