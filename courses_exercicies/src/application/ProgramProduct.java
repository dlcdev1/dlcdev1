package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class ProgramProduct {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		List<Product> user_list= new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int number_products = sc.nextInt();
		
		
		for (int i=1; i<=number_products; i++) {
			
			System.out.printf("Product #%s\n", i);
			System.out.print("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0);
			sc.nextLine();	
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (type == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				user_list.add(new ImportedProduct(name, price, customsFee));
			}
			else if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				user_list.add(new UsedProduct(name, price, manufactureDate));
			}
			else if (type == 'c') {
				user_list.add(new Product(name, price));
			}
			
		}
		
		System.out.println("PRICE TAGS:");
		
		for (Product product : user_list) {
			System.out.println(product.getName() + product.priceTag());
		}
		
		
		sc.close();
		

	}

}
