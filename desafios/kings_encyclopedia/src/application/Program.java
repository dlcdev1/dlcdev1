package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.KingSort;

public class Program {

	public static void main(String[] args) {
		
		String regex = "[a-z]";
		Scanner sc = new Scanner(System.in);
		List<KingSort> kings = new ArrayList<>();

		System.out.println("Enter the names of kings: ");
		String kings_name = sc.nextLine();
		String[] change = kings_name.split(regex);
		

		for (String king : change) {
			System.out.println(king);
		}

		sc.close();
	}

}
