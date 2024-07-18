package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
	public static void main(String[] args) {
		// 사용자 입력 받기
		Scanner sc = new Scanner(System.in);
		// 숫자 하나 골라서 100에 나누기
		final int HUNDRED = 100;

		while (true) {
			System.out.print("숫자 입력(종료를 원하면 '종료' 입력) : ");
			String input = sc.next();

			if (input.equals("종료")) {
				break;
			}

			// try : 예외가 발생할 수 있는 코드 포함
			try {
				int number = Integer.parseInt(input);

				int result = divide(HUNDRED, number);
				System.out.println(result);
			}
			// catch : try 블록에서 예외가 발생했을 때 실행되는 코드를 포함
			catch (ArithmeticException e) {
				// ArithmeticException : 연산 자체가 불가능할 때 발생하는 실행 예외
				e.printStackTrace();
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
		sc.close();

	}

	// 예외 떠넘기기
	private static int divide(int x, int y) throws ArithmeticException {
		int result = x / y;
		return result;
	}
}
