package com.reference.list;

public class ListPractice {

	public static void main(String[] args) {
		String[] season = { "봄", "여름", "가을", "겨울" };

		for (int i = 0; i < season.length; i++) {
			System.out.println(season[i]);
		}

		season[0] = "Spring";
		season[1] = "Summer";
		season[2] = "Autumn";
		season[3] = "Winter";

		for (int i = 0; i < season.length; i++) {
			System.out.println(season[i]);
		}

	}

}
