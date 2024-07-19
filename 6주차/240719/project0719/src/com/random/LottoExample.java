package com.random;

import java.util.Arrays;
import java.util.Random;

public class LottoExample {

	public static void main(String[] args) {
		int[] selectNum = new int[6];
		Random r = new Random();
		int count = 0;

		// random 숫자로 6개 배열 생성 (중복 시 다시 뽑기)
		while (count < selectNum.length) {
			int num = r.nextInt(45) + 1;
			boolean isUnique = true;

			for (int i = 0; i < count; i++) {
				if (selectNum[i] == num) {
					isUnique = false;
					break;
				}
			}

			if (isUnique) {
				selectNum[count] = num;
				count++;
			}
		}

		System.out.println(Arrays.toString(selectNum));

	}

}
