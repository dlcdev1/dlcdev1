package application;

import entities.AccountHeranca;
import entities.BusinessAccountHeranca;
import entities.SavingsAccountHerancaUpDCasting;

public class ProgramHeranca {

	public static void main(String[] args) {
		
//		AccountHeranca acc = new AccountHeranca(1001, "Alex", 0.0);
//		BusinessAccountHeranca bacc = new BusinessAccountHeranca(1002, "Maria", 0.0, 500.);
//		
//		// UPCATING
//		AccountHeranca acc1 = bacc;
//		AccountHeranca acc2 = new BusinessAccountHeranca(1003, "Bob", 0.0, 200.0);
//		AccountHeranca acc3 = new SavingsAccountHerancaUpDCasting(1004, "Anna", 0.0, 0.01);
//		
//		// DOWNCASTING
//		
//		BusinessAccountHeranca acc4 = (BusinessAccountHeranca) acc2;
//		acc4.loan(100.0);
//		
//		
//		if (acc3 instanceof BusinessAccountHeranca) {
//			BusinessAccountHeranca acc5 = (BusinessAccountHeranca) acc3;
//			acc5.loan(200.0);
//			System.out.println("Loan!");
//		}
//		
//		if (acc3 instanceof SavingsAccountHerancaUpDCasting) {
//			SavingsAccountHerancaUpDCasting acc5 = (SavingsAccountHerancaUpDCasting) acc3;
//			acc5.updateBalance();
//			System.out.println("update!");
//		}
		
		AccountHeranca acc1 = new AccountHeranca(1001, "Alex", 1000.0);
		acc1.withdraw(200.0);
		System.out.println(acc1.getBalance());
		
		AccountHeranca acc2 = new SavingsAccountHerancaUpDCasting(1002, "Maria", 1000.0, 0.01);
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance());
		
		AccountHeranca acc3 = new BusinessAccountHeranca(1002, "Bob", 1000.0, 500.0);
		acc3.withdraw(200.0);
		System.out.println(acc3.getBalance());
		
	}

}
