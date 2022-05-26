package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class ProgramOrderItem {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
		
		Date date = new Date();
				
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter Client data");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date bith_date = sdf.parse(sc.next());
		sc.nextLine();
		
		Client client = new Client(name, email, bith_date);
		
		System.out.println("Enter order data: ");
		String moment = dtf.format(LocalDateTime.now());
		System.out.println("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items this order? ");
		int quantity_itens = sc.nextInt();
		
		for(int i=0; i <quantity_itens; i++) {
			sc.nextLine();
			System.out.printf("Enter #%s item data: \n", i);
			System.out.println("Product name: ");
			String product_name = sc.nextLine();
			
			System.out.println("Product price: ");
			Double product_price = sc.nextDouble();
			
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			
			Product product = new Product(product_name, product_price);
			
			OrderItem order_item = new OrderItem(quantity, product_price, product);

			order.addItem(order_item);			
			
		}
		System.out.println();
		System.out.println(order);
		
		
		sc.close();

	}

}
