package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
		
		System.out.println("고객번호 = " + account.getCustId());
		System.out.println("계좌번호 = " + account.getAcctId());
		System.out.println("잔액 = " + account.getBalance());
		
	}
}