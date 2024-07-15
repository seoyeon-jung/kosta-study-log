package com.oop.practice3;

public class Account {
	private static final int MIN_BALANCE = 0;
	private static final int MAX_BALANCE = 1_000_000;
	private int balance;

	public Account(int balance) {
		setBalance(balance);
		// 0원으로 만들어지도록
	}

	private int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}
	}

	// info
	public void info() {
		System.out.println("현재 잔고: " + getBalance() + "원");
	}

	// withdraw (출금)
	public void withdraw(int amount) {
		if (amount >= MIN_BALANCE) {
			setBalance(balance - amount);
			System.out.println(amount + "원 출금 완료");
		}
//		if (amount > MIN_BALANCE && amount <= balance) {
//			setBalance(balance - amount); // setBalance 사용해서 범위 조건 체크
//			// balance -= amount;
//			System.out.println(amount + "원 출금 완료");
//		} else {
//			System.out.println("출금할 수 없습니다. 잔고 부족 또는 유효하지 않은 금액입니다.");
//		}
	}

	// deposit (입금)
	public void deposit(int amount) {
		if (amount >= MIN_BALANCE) {
			setBalance(balance + amount);
			System.out.println(amount + "원 입금 완료");
		}
//		if (amount > 0 && balance + amount <= MAX_BALANCE) {
//			balance += amount;
//			System.out.println(amount + "원 입금 완료");
//		} else {
//			System.out.println("최대 금액 초과로 입금 불가");
//		}
	}
}
