package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			System.out.printf("\n\n****************************EMPLOYEE %d****************************\n\n", i + 1);
			System.out.printf("Enter the employee's name: ");
			sc.nextLine();
			String name = sc.nextLine();
			int id;
			do {
				System.out.printf("Enter the employee's ID: ");
				id = sc.nextInt();
				if (searchEmployee(list, id) != null)
					System.out.println("This ID already exists!!!");
			} while (searchEmployee(list, id) != null);

			System.out.printf("Enter the employee's base salary: ");
			double salary = sc.nextDouble();
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
		}

		System.out.print("\n\nEnter the employee's ID that you wish to increasse the salary: ");
		int id = sc.nextInt();

		Employee auxEmployee = searchEmployee(list, id);

		if (auxEmployee != null) {
			System.out.print("\nEnter the percentage of the increasse: ");
			double percentage = sc.nextDouble();
			auxEmployee.increasseSalary(percentage);

			System.out.println("ID    NAME          SALARY");
			for (Employee x : list)
				System.out.println(x);
		} else
			System.out.println("ID not found!!!");

		sc.close();
	}

	public static Employee searchEmployee(List<Employee> list, int id) {
		for (Employee x : list)
			if (x.getId() == id)
				return x;
		return null;
	}

}
