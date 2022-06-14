package entities;

public class Company extends TaxPayer {
	
	
	private Integer numberOfEmployees;
	
	public Company() {
		
	}
	
	
	public Company(String name, Double anual_income, Integer numberOfEmployees) {
		super(name, anual_income);
		this.numberOfEmployees = numberOfEmployees;
	}


	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}


	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}


	@Override
	public double tax() {
		double amount = 0;
		double income = getAnual_income();
		int minimum_employee = 10;
				
		if (numberOfEmployees <= minimum_employee) {
			amount = income - (income * 0.16);
		}
		else {
			amount = income * 0.14;
		}
		
		return amount;
	}

}
