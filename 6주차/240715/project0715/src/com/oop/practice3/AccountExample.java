package com.oop.practice3;

public class AccountExample {

	public static void main(String[] args) {
		Account acc = new Account(10000); // 만원이 들어있는 계좌 생성
		acc.info(); // 현재 잔고: 10000원 출력

		acc.withdraw(10000); // 10000원 출금
		acc.info(); // 현재 잔고: 0원 출력

		acc.deposit(2000000); // 2000000원 입금 (최대 금액 초과로 입금 불가)
		acc.info(); // 현재 잔고: 0원 출력

		acc.deposit(50000); // 50000원 입금
		acc.info(); // 현재 잔고: 50000원 출력

	}

}
