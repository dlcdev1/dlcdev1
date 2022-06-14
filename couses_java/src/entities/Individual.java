package entities;

public class Individual extends TaxPayer{

	private double healthExpeditures;
	
	public Individual() {
		
	}
	
	public Individual(String name, Double anual_income, double healthExpeditures) {
		super(name, anual_income);
		this.healthExpeditures = healthExpeditures;
	}
	

	public double getHealthExpeditures() {
		return healthExpeditures;
	}

	public void setHealthExpeditures(double healthExpeditures) {
		this.healthExpeditures = healthExpeditures;
	}

	@Override
	public double tax() {
		double income = getAnual_income();
		double minimum_value = 20000.00;
		double amount = 0;
		
		if (income <= minimum_value) {
			amount = (income * 0.15) - (healthExpeditures * 0.25);
		}
		else {
			amount = (income * 0.25) - (healthExpeditures * 0.50);
		}

		return amount;
	}

}
