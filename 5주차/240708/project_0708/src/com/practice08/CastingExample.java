package com.practice08;

public class CastingExample {

	public static void main(String[] args) {
//		int intValue = 1000000;
//		byte byteValue = (byte) intValue;
//		System.out.println(byteValue); // 64

		int var1 = 10;
		byte var2 = (byte) var1;
		System.out.println(var2); // 10

		long var3 = 300;
		int var4 = (int) var3;
		System.out.println(var4); // 300

		int var5 = 65;
		char var6 = (char) var5;
		System.out.println(var6); // A

		double var7 = 3.14;
		int var8 = (int) var7;
		System.out.println(var8); // 3 (데이터 누락 발생)

	}

}
