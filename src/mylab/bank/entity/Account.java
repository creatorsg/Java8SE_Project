package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

// 모든 계좌의 기본이 되는 추상 클래스
public abstract class Account {
	protected String accountNumber;
	protected String ownerName;
	protected double balance;

	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	// 입금 처리
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(String.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원", amount, balance));
	}

	// 출금 처리 
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException(
					String.format("잔액이 부족합니다. 현재 잔액: %.1f원", balance));
		}
		this.balance -= amount;
		System.out.println(String.format("%.1f원이 출금되었습니다. 현재 잔액: %.1f원", amount, balance));
	}

	@Override
	public String toString() {
		return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원", accountNumber, ownerName, balance);
	}
}