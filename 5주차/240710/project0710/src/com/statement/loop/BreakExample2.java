package com.statement.loop;

public class BreakExample2 {

	public static void main(String[] args) {
		for (char upper = 'A'; upper <= 'Z'; upper++) {
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + " - " + lower);

				if (lower == 'c') {
					break;
				}
			}
		}
	}

}
