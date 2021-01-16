package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	private Department dpt;	
	private List<HourContract> ctrts = new ArrayList<HourContract>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary,Department dpt) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.dpt = dpt;
	}
	
	public void addContract(HourContract ctrt) {
		ctrts.add(ctrt);
	}
	
	public void removeContract(HourContract ctrt) {
		ctrts.remove(ctrt);
	}
	
	public double income (int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : ctrts) {
			cal.setTime(c.getDate());
			
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if(c_year == year && c_month == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDpt() {
		return dpt;
	}

	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}

	public List<HourContract> getCtrt() {
		return ctrts;
	}
	
}
