package com.system;

import java.util.Arrays;

public class ByteToStringExample {
	public static void main(String[] args) throws Exception {
		String data = "정서연";
		byte[] arr1 = data.getBytes();
		System.out.println(Arrays.toString(arr1));
		// [-20, -96, -107, -20, -124, -100, -20, -105, -80]
		String str1 = new String(arr1);
		System.out.println(str1);

		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println(Arrays.toString(arr2));
		// [-63, -92, -68, -83, -65, -84]
		String str2 = new String(arr2, "EUC-KR");
		System.out.println(str2);
	}
}
