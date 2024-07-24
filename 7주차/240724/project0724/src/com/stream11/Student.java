package com.stream11;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student implements Comparable<Student> {
	private String name;
	private int score;

	@Override
	public int compareTo(Student o) {
		// return Integer.compare(score, o.score);
		return score - o.score;
	}
}
