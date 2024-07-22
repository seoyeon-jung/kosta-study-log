package com.anonymous;

public class Human {
	HumanService hs;

	public Human() {
	}

	public Human(HumanService hs) {
		super();
		this.hs = hs;
	}

	public void work() {
		System.out.println("농사를 짓는다.");
	}

	public void start() {
		if (hs != null) {
			hs.run();
		} else {
			work();
		}
	}
}