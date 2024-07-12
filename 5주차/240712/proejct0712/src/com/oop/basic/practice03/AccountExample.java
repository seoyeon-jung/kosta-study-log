package com.oop.basic.practice03;

public class AccountExample {

	public static void main(String[] args) {
		// account 객체 생성
		Account myAccount = new Account("441-0290-1203", 500000, 7.3);

		// account 객체의 계좌정보 출력
		System.out.println("계좌정보: " + myAccount.account + "\t현재잔액: " + myAccount.balance);

		// account 에서 600000원 출금
		myAccount.deposit(600000);

		// account 에 20000원 입금
		myAccount.withdraw(20000);

		// account 객체의 계좌정보 출력
		System.out.println("계좌정보: " + myAccount.account + "\t현재잔액: " + myAccount.balance);

		// 이자 출력 – 현재 잔고를 기준으로 고객에게 줄 이자 금액을 출력 한다
		System.out.println("이자: " + myAccount.calculateInterest());

	}

}
