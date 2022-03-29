package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.EmployeerList;

public class ProgramEmployeerList {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<EmployeerList> employeeList = new ArrayList<>();

		EmployeerList employee = null;
		int id = 0;
		System.out.print("How many employees will be restiered? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("\nEmployee #" + (i + 1));
			System.out.print("Id: ");
			id = sc.nextInt();
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			employee = new EmployeerList(id, name, salary);
			employeeList.add(employee);

		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();
		
		EmployeerList emp = employeeList.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

		
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.println("Enter the percentagem: ");
			double percentage = sc.nextDouble();
			employee.findEmployeeAndSetPercentagem(employeeList, id, percentage);
		}

		System.out.println("\nList of employees: ");

		for (int i = 0; i < employeeList.size(); i++) {
			System.out.println(employeeList.get(i).getId() + ", " + employeeList.get(i).getName() + ", "
					+ employeeList.get(i).getSallary());
		}

		sc.close();

	}

}
