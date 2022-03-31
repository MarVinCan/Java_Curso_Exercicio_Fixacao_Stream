package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				String[] parts = line.split(",");
				
				String name = parts[0];  
				String eMail = parts[1];
				double salary = Double.parseDouble(parts[2]);
				
				list.add(new Employee(name, eMail, salary));
				
				line = br.readLine();
			}
			System.out.print("Enter salary: ");
			double biggerThen = sc.nextDouble();
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()); 
			System.out.println("Email of people whose salary is more than"+ String.format(" %.2f", biggerThen));
			List<String> eMails = list.stream()
					.filter(e -> e.getSalary()>biggerThen)
					.map(e -> e.geteMail())
					.sorted(comp)
					.collect(Collectors.toList());
			eMails.forEach(System.out::println);
			
			double sum = list.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (x,y) -> x + y);
			System.out.println("Sum of salary of people whose name starts with 'M': "+ String.format("%.2f", sum));
			
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
