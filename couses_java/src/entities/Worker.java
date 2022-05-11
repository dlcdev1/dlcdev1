package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel leve;
	private Double baseSalary;

	private Department departement;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel leve, Double baseSalary, Department departement) {
		this.name = name;
		this.leve = leve;
		this.baseSalary = baseSalary;
		this.departement = departement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLeve() {
		return leve;
	}

	public void setLeve(WorkerLevel leve) {
		this.leve = leve;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartement() {
		return departement;
	}

	public void setDepartement(Department departement) {
		this.departement = departement;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContratct(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar calendar = Calendar.getInstance();
		for (HourContract contract : contracts) {
			calendar.setTime(contract.getDate());
			int contract_year = calendar.get(Calendar.YEAR);
			int contract_month = 1 + calendar.get(Calendar.MONTH);
			if (year == contract_year && month == contract_month) {
				sum += contract.totalValeu();
			}
		}

		return sum;
	}

}
