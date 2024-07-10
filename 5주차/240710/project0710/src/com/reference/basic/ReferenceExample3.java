package com.reference.basic;

public class ReferenceExample3 {

	public static void main(String[] args) {
//		int[] arr1 = { 1, 2, 3 };
//
//		for (int i = 0; i < 4; i++) {
//			int j = arr1[i];
//			System.out.println(j); // 1 2 3
//			// 이후 Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//			//at com.reference.basic.ReferenceExample3.main(ReferenceExample3.java:9) 에러 발생
//			
//		}

		String[] names = { "A", "B", "C" };
		// String[] names = { "A", "B", "C", null };

		for (int i = 0; i < 4; i++) {
			String name = names[i];
			System.out.println(name.charAt(0));
			// A, B, C 출력 이후 에러 발생
			// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3
			// out of bounds for length 3
			// at com.reference.basic.ReferenceExample3.main(ReferenceExample3.java:19)
		}

	}

}
