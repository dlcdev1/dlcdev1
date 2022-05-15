package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ProgramOrderItem {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter quantity itens? ");
		int quantity_itens = sc.nextInt();
		
		System.out.println("Enter Client data: ");
		for(int i=0; i <quantity_itens; i++) {
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Birth date (DD/MM/YYYY)");
			Date bith_date = sdf.parse(sc.next());
			
			System.out.println("Enter order data");
			
			
			
			
		}
		
		
		
		
		
		
		
		sc.close();

	}

}
