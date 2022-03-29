package entities;

import java.util.ArrayList;
import java.util.List;

public class EmployeerList {
	private int id;
	private String name;
	private double sallary;
	
	public EmployeerList(int id, String name, double sallary) {
		this.id = id;
		this.name = name;
		this.sallary = sallary;
	}
	
	public EmployeerList() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSallary() {
		return sallary;
	}
	
	private void setPercentageInSallary(double percentagem) {
		this.sallary += percentagem;
	}
	
	public boolean findEmployer(List<EmployeerList> employeeList, int idSalary) {
		EmployeerList emp = employeeList.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		return emp != null;
	}
	
	public void findEmployeeAndSetPercentagem(List<EmployeerList> employeeList, int _id, double percentage) {
		
		for (int i=0; i<employeeList.size(); i++) {
			if (employeeList.get(i).getId() == _id) {
				double _salary = 0;
				percentage = employeeList.get(i).getSallary() * (percentage/100);
				employeeList.get(i).setPercentageInSallary(percentage);
				continue;
			} 
		}
	}

}
