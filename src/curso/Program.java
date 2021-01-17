package curso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		//Date dateP = new Date();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department's name:");
		String dpt = sc.nextLine();
		System.out.println();
		
		System.out.println("Enter Worker Data:");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Level:");
		String lvl = sc.next();
		System.out.println("Base Salary:");
		double bs = sc.nextDouble();
		
		Worker worker = new Worker(name,WorkerLevel.valueOf(lvl),bs,new Department(dpt));

		System.out.println("How many contracts to this worker?");
		int quant_ctrt = sc.nextInt();
		
		for(int i=1; i<=quant_ctrt; i ++ ) {
			sc.nextLine();
			System.out.printf("Enter contract {} Data:",i);
			System.out.println("Date (DD/MM/YY): ");
			String date = sc.nextLine();
			
			System.out.println("Value per hour: ");
			Double value = sc.nextDouble();
			
			System.out.println("Duration (hours): ");
			int duracao = sc.nextInt();
			
			SimpleDateFormat format =new SimpleDateFormat("dd/MM/yyyy");
			Date datap = (Date)format.parse(date);
			System.out.println(datap);
			HourContract hc = new HourContract(datap,value,duracao);
			
			worker.addContract(hc);
		}
		
		
		
//		int cont = 0;
//		for (HourContract ctrt: worker.getCtrt()) {
//			cont++;
//			System.out.println(cont);
//			System.out.println(ctrt);
//		}
		
		sc.nextLine();
		System.out.println("Enter month and year to calculate income MM/YYYY: ");
		String mes_ano = sc.nextLine();
		System.out.println("Name: ");
		String nome = sc.nextLine();
		System.out.println("Department: ");
		String depart = sc.nextLine();
		
		
		int month = Integer.parseInt(mes_ano.substring(0, 2));
		int year = Integer.parseInt(mes_ano.substring(3));

		
		double income = worker.income(year, month);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDpt().getName());
		System.out.println("Income for "+mes_ano+ ": "+income);
		
		
		sc.close();

	}

}
