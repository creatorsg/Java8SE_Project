package mylab.bank.entity;

public class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	// 이자 적용 
	public void applyInterest() {
		double interest = balance * interestRate;
		deposit(interest);
		System.out.println(String.format("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원", interest, balance));
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", 이자율: %.1f%%", interestRate * 100);
	}
}