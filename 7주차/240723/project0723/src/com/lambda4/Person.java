package com.lambda4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Person /* implements Comparable<Person> */ {
	private String name;
	private int age;

//	@Override
//	public int compareTo(Person o) {
//		// 나이를 통해 비교
//		// return Integer.valueOf(age).compareTo(o.getAge());
//
//		if (age < o.getAge())
//			return -1;
//		else if (age == o.getAge())
//			return 0;
//		return 1;
//	}

}
