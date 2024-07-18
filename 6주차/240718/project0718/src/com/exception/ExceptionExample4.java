package com.exception;

public class ExceptionExample4 {

	public static void main(String[] args) {
		String[] strArr = { "80", "90", null, "1oo" };

		for (int i = 0; i <= strArr.length; i++) {
			try {
				String str = strArr[i];
				int value = Integer.parseInt(str);
				System.out.println("strArr[" + i + "] : " + value);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
			} catch (NumberFormatException | NullPointerException e) {
				System.out.println("데이터에 이상이 있음: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("실행에 문제가 있습니다.");
			}
		}
	}

}
