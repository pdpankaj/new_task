/**
 * 
 */
package com.j8.filter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FilterExample {

	public static void main(String[] args) {
		List<Employee> employees = getEmployees();

		// Sort all employees by first name
		employees.sort(Comparator.comparing(e -> e.getName()));

		employees.stream().filter(employee -> employee.getAge() > 26).forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------");

		// Create a HashMap with custom key
		Map<Employee, String> map = new HashMap<Employee, String>();
		for (Employee emp : employees) {
			map.put(emp, emp.getName());
		}
		
		 for (Map.Entry<Employee, String> entry : map.entrySet()) {
		        System.out.println(entry.getKey() + "::::::::::" + entry.getValue());
		    }
	}

	private static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		LocalDate localDate = LocalDate.now();
		employees.add(new Employee(26, "Sachin Chopra", localDate.minusYears(26)));
		employees.add(new Employee(22, "Aman Sharma", localDate.minusYears(22)));
		employees.add(new Employee(33, "Aakash Yadav", localDate.minusYears(33)));
		employees.add(new Employee(45, "David Boon", localDate.minusYears(45)));
		employees.add(new Employee(34, "James Bond", localDate.minusYears(34)));
		employees.add(new Employee(28, "Balaji Subramanian", localDate.minusYears(38)));
		employees.add(new Employee(37, "Karan Patel", localDate.minusYears(37)));
		employees.add(new Employee(31, "Aakesh Gupta", localDate.minusYears(31)));
		employees.add(new Employee(19, "Vishnu Patil", localDate.minusYears(19)));
		employees.add(new Employee(20, "Prakash Chandra", localDate.minusYears(20)));
		return employees;
	}

}

class Employee {

	private int age;
	private String name;
	private LocalDate dob;

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Employee(int age, String name, LocalDate dob) {
		super();
		this.age = age;
		this.name = name;
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", dob=" + dob + "]";
	}

}
