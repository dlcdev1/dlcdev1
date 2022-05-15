package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.KingSort;
import entities.Kings;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<String> kings_sort = new ArrayList<>();
		Kings king = new Kings();

		System.out.print("Enter quantity of kings: ");
		String quantity_kings = sc.nextLine();

		for (int i = 0; i <= quantity_kings.length(); i++) {
			System.out.println(String.format("Enter the names of %s kings: ", i+1));
			String kings_name = sc.nextLine();
			king.setName(kings_name);
			kings_sort.add(kings_name);
		}
		
		for (String string : kings_sort) {
			System.out.println("Este é um rei:" + string);
		}

//		System.out.println(kings_name.replaceAll(regex, ""));

		sc.close();
	}

}
