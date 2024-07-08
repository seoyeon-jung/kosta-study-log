package com.practice05;

public class IntExample {
	public static void main(String[] args) {
		long var1 = 10; // int로 변환 가능
		long var2 = 20L;
		long var3 = 2_147_483_647; // int로 변환 가능
		long var4 = 2147483648L; // int의 허용 범위 초과
		
		// int var5 = 2147483648;
		int var6 = 2_147_483_647;
		
		System.out.println(var1); // 10
		System.out.println(var2); // 10
		System.out.println(var3); // 2147483647
		System.out.println(var4); // 2147483648
		//System.out.println(var5); // Type mismatch: cannot convert from long to int
		//System.out.println(var5); // The literal 2147483648 of type int is out of range
		System.out.println(var6+10); // -2147483639
	}
}
