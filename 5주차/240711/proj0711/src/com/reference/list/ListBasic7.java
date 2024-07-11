package com.reference.list;

public class ListBasic7 {

	public static void main(String[] args) {
		// 배열의 길이를 늘리는 방법1
		int[] oldArr = { 1, 2, 3 };

		// 길이 세개인 old 배열을 다섯개로 늘리자
		int[] newArr = new int[5]; // {0, 0, 0, 0, 0}
		for (int i = 0; i < oldArr.length; i++) {
			newArr[i] = oldArr[i];
		}

		// 배열의 길이를 늘리는 방법2 = array copy
		// System.arraycopy(원본 배열, 복사를 시작할 위치, 새배열, 붙여넣기 시작할 위치, 복사할 개수);
		int[] oldArr2 = { 1, 2, 3 };
		int[] newArr2 = new int[5];

		System.arraycopy(oldArr2, 0, newArr2, 0, newArr2.length);
	}
}
