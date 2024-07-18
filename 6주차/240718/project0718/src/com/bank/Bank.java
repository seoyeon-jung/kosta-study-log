package com.bank;

// 은행 클래스
public class Bank {

	// 은행 필드 (은행 이름)
	private String name;
	private Account[] accounts;
	private int total_account_count = 0;
	// 은행은 최대 10개의 계좌를 갖는다
	private static final int MAX_ACCOUNT_COUNT = 10;

	// 은행 생성자
	public Bank(String name) {
		super();
		this.setName(name);
		this.accounts = new Account[MAX_ACCOUNT_COUNT];
	}

	// 계좌 개설 메소드
	public Account openAccount() {
		accounts[total_account_count] = new Account();
		Account acc = accounts[total_account_count];
		this.total_account_count++;
		return acc;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 은행에는 계좌 클래스가 있다
	class Account {
		// 계좌 필드 (잔고[balance], 계좌번호(String)[A1000, A1001, ... , A1009])
		private String accountID;
		private int balance = 0;

		public Account() {
			this.accountID = "A" + (1000 + Bank.this.total_account_count);
		}

		// 계좌 메소드 (잔액 출력[toString], 입금[deposit], 출금[withdraw])
		@Override
		public String toString() {
			return "[accountID=" + accountID + ", balance=" + balance + "]";
		}

		public void deposit(int money) {
			this.balance += money;
		}

		public void withdraw(int money) throws MyException {
			if (this.balance >= money) {
				this.balance -= money;
			} else {
				throw new MyException("잔액이 부족합니다.");
			}
		}

	}

}
