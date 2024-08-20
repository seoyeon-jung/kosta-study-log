package com.kosta.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
	@DisplayName("1+2 = 3 검증") // 테스트 이름 지정할 수 있음
	@Test // 테스트 메소드 명시
	public void junitTest() {
		// given
		int a = 1;
		int b = 2;
		int sum = 3;

		// when
		int result = a + b;

		// then
		// assertEquals(기대값, 검증할 값)
		Assertions.assertEquals(sum, result);
	}

//	@DisplayName("1+3 = 3 검증") // 테스트 이름 지정할 수 있음
//	@Test // 테스트 메소드 명시
//	public void junitTest2() {
//		// given
//		int a = 1;
//		int b = 3;
//		int sum = 3;
//
//		// when
//		int result = a + b;
//
//		// then
//		// assertEquals(기대값, 검증할 값)
//		Assertions.assertEquals(sum, result);
//	}

}
