package workshop.account.exception;

public class InsufficientBalanceException extends Exception {
	pritvate int currentBalance;
	
	public InsufficientBalanceException(String errorMessage, int currentBalance) {
		super(errorMessage);
		this.currentBalance = currentBalance;
	}
	
	public int getCurrentBalance() {
		return currentBalance;
	}
}
