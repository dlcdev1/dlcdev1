package entities;

public class SavingsAccountHerancaUpDCasting extends AccountHeranca {
	
	private Double interestRate;
	
	public SavingsAccountHerancaUpDCasting() {
		super();
	}

	public SavingsAccountHerancaUpDCasting(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

}
