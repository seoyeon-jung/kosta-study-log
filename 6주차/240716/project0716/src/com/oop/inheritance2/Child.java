package com.oop.inheritance2;

public class Child extends Parents {
	private String job = "개발자";

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	void hello() {
		System.out.println("안녕하세요");
	}

	@Override
	void walk() {
		System.out.println("뚜벅뚜벅");
	}
}
