package EmployeeManagementSystem;

import java.util.Objects;

public class Employee 
{
	private int id;
	private String name;
	private int  age;
	private String desiganation;
	private String department;
	private double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesiganation() {
		return desiganation;
	}
	public void setDesiganation(String desiganation) {
		this.desiganation = desiganation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee ID: " + id + "\n" +
	               "Employee Name: " + name + "\n" +
	               "Age: " + age + "\n" +
	               "Desiganation: " + desiganation + "\n" +
	               "Employee Department: " + department + "\n"+
	               "Employee Salary: " + salary + "\n";
				
	}
	public Employee(int id,String name,int age,String desiganation,String department,double salary) 
	{
	
		this.id = id;
		this.name = name;
		this.age = age;
		this.desiganation = desiganation;
		this.department = department;
		this.salary = salary;
	}
	
	
	
	
	
	
}


