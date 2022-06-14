package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

import entities.AccountHeranca;
import entities.BusinessAccountHeranca;
import entities.SavingsAccountHerancaUpDCasting;

public class ProgramAccount {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<AccountHeranca> list = new ArrayList<>();
		list.add(new SavingsAccountHerancaUpDCasting(1001, "Alex", 500.0, 0.01));
		list.add(new BusinessAccountHeranca(1002, "Maria", 1000.0, 400.0));
		list.add(new SavingsAccountHerancaUpDCasting(1004, "Bob", 300.0, 400.0));
		list.add(new BusinessAccountHeranca(1005, "Anna", 500.0, 500.0));
		
		double sum = 0.0;
		
		for (AccountHeranca acc : list) {
			sum += acc.getBalance();
		}
		System.out.printf("Total balance: %.2f%n", sum);
		
		for (AccountHeranca acc : list) {
			acc.deposit(10.0);
		}
		
		for (AccountHeranca acc: list) {
			System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}
		

	}

}
