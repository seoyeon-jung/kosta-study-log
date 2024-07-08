package com.practice10;

public class OverflowExample {

	public static void main(String[] args) {
		byte byteValue = 127; // byte의 최고값
		System.out.println(++byteValue); // -128 (범위를 초과하기 때문)(메모리에 -128 존재)
		System.out.println(--byteValue); // 127 (더 빼줄 게 없어서 다시 127로 늘어남)

		short shortValue = 32767;
		System.out.println(++shortValue); // -32768 (범위를 초과하기 때문)
		System.out.println(--shortValue); // 32767

		int intValue = 2_147_483_647;
		System.out.println(++intValue); // -2147483648 (범위를 초과하기 때문)
		System.out.println(--intValue); // 2147483647

		long longValue = 9_223_372_036_854_775_807L;
		System.out.println(++longValue); // -9223372036854775808 (범위를 초과하기 때문)
		System.out.println(--longValue); // 9223372036854775807

		byte var1 = 125;
		for (int i = 0; i < 5; i++) {
			if (Byte.MAX_VALUE == var1) {
				break;
			}
			// if 문으로 조건을 넘지 않도록 한다.
			/*
			 * if문 추가해서 출력하면 아래 값들만 나온다. var1: 126 var1: 127
			 */
			var1++;
			System.out.println("var1: " + var1);
		}
		/*
		 * var1: 126 var1: 127 var1: -128 var1: -127 var1: -126
		 */

		byte var2 = 125;
		for (int i = 0; i < 5; i++) {
			var2--;
			System.out.println("var2: " + var2);
		}
		/*
		 * var2: 124 var2: 123 var2: 122 var2: 121 var2: 120
		 * 
		 */
	}

}
