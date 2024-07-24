package com.lambda2;

public class Member {
	private String id, name;

	public Member(String id) {
		this.id = id;
		System.out.println("멤버(id만으로 생성)");
	}

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("멤버(id, name으로 생성)");
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}

}
