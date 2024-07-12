package com.oop.basic.practice03;

public class Account {
	String account; // 계좌번호
	int balance; // 잔액
	double interestRate; // 이율

	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	// 이자 계산
	double calculateInterest() {
		double interest = (double) balance * (interestRate / 100);
		return interest;
	}

	// 출금
	void deposit(int money) {
		if (balance - money > 0) {
			balance -= money;
			System.out.println(money + "원을 출금했습니다.");
		} else {
			System.out.println("출금할 수 없습니다.");
		}
	}

	// 입금
	void withdraw(int money) {
		// 마이너스 입금은 불가능
		if (money < 0) {
			return;
		}
		balance += money;
	}
}
