package com.collection.set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private String name;
	private int age;

//	public Member(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}

//	@Override
//	public int hashCode() {
//		return name.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Member) {
//			Member m = (Member) obj;
//			return m.name.equals(name) && m.age == age;
//		}
//		return false;
//	}

}
