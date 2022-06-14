package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class ProgramTaxEmployeer {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String name = "";
		Double anualIncome = 0.00;
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			
			System.out.printf("Tax payer #%d data:", i);
			System.out.print("Individual or company (i/c)? ");
			
			char ch = sc.next().charAt(0);
			sc.nextLine();
			
			if (ch == 'i') {
				System.out.print("Name: ");
				name = sc.nextLine();
				System.out.print("Anual income: ");
				anualIncome = sc.nextDouble();
				
				System.out.print("Health expeditures: ");
				Double healthExpeditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpeditures));
				
			} else {
				System.out.print("Name: ");
				name = sc.nextLine();
				System.out.print("Anual income: ");
				anualIncome = sc.nextDouble();
				System.out.println("Number of employees");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
				
			}
			
			
		}
		
		System.out.println();
		
		System.out.println("TAXES PAID");
		
		for(TaxPayer tax_payer : list) {
			System.out.printf(tax_payer.getName() + ": $ %.2f%n", tax_payer.tax());
		}
		
		double amount = 0.00;
		
		for (TaxPayer tax_payer: list) {
			amount += tax_payer.tax();
		}
		
		System.out.printf("TOTAL TAXES: $ %.2f", amount);
		
		sc.close();
	
	}

}
