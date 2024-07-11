package com.reference.list;

public class ListBasic3 {

	public static void main(String[] args) {
		String[] season;
		// season = { "봄", "여름", "가을", "겨울" }; // 컴파일 에러
		season = new String[] { "봄", "여름", "가을", "겨울" };

		for (int i = 0; i < season.length; i++) {
			System.out.println(season[i]);
		}

		// 배열의 길이가 변경된 것이 아니라, 다른 배열ㅇ르 여견해주어서 변경된 것처럼 보이는 것
		season = new String[] { "Spring", "Summer", "Autumn" };
		// 값은 변경된 게 아니라 새로운 주소와 연결만 시켜둔 것(연결은 끊겼기 때문에 쓰레기 객체로 남아있음)
		// 길이는 절대 변경 불가이므로 Winter 를 제거해도 에러가 발생하지 않는다.

		for (int i = 0; i < season.length; i++) {
			System.out.println(season[i]);
		}
	}

}
