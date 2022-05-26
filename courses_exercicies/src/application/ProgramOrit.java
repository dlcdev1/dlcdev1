package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;

public class ProgramOrit {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		Product p = new Product("TV", 1000.0);
		
		OrderItem oi1 = new OrderItem(1, 1000.0, p);
		
		System.out.println(oi1);
		
		Client cli = new Client("Maria", "maria@gmail.com", sdf.parse("20/10/1995"));
		
		System.out.println(cli);
		sc.close();
	}

}
