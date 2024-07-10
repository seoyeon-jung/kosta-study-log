package com.statement.loop;

public class BreakExample3 {

	public static void main(String[] args) {
		Outter: for (char upper = 'A'; upper <= 'Z'; upper++) {
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + " - " + lower);

				if (lower == 'c') {
					break Outter;
				}
			}
		}
	}

}
