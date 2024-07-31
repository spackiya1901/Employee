package EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
		private static Employee employees;

		public static void main(String args[]) throws ClassNotFoundException, SQLException
		{
        int id1;
        String newName;
        String newDepartemnt;
        double newSalary;
       
		Database db= new Database();	
		Scanner sc=new Scanner(System.in);
		System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
		System.out.println("***************************");
		System.out.println("LOGIN");
		System.out.println("******");
		System.out.print("Enter username: ");
	    String username = sc.nextLine();
	    System.out.print("Enter password: ");
	    String password = sc.nextLine();

	    if ("admin".equals(username) && "admin123".equals(password)) {
	        System.out.println("Login successful!");

	        while (true) {
	            System.out.println("\n1. Add Employee");
	            System.out.println("2. Update Employee");
	            System.out.println("3. View Employee");
	            System.out.println("4.Delete Employee");
	            System.out.println("5.View All Employee");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");
	            int option = sc.nextInt();
	            sc.nextLine();  // Consume newline
	           
	            switch (option) {
	                case 1:
	                	
	            		System.out.println("Enter name:");
	            		String name=sc.next();
	            		System.out.println("Enter age:");
	            		int age=sc.nextInt();
	            		System.out.println("Enter Desiganation:");
	            		String desiganation=sc.next();
	            		System.out.println("Enter Department:");
	            		String department=sc.next();
	            		System.out.println("Enter salary:");
	            		double salary=sc.nextDouble();
	            		Employee newEmployee=new Employee(0,name,age,desiganation,department,salary);
	            		db.AddEmployee(newEmployee);
	            		break;
	                    
	                case 2:
	                	System.out.print("Enter employee ID to update: ");
                         id1 = sc.nextInt();
                        System.out.print("Enter new name: ");
                         name = sc.next();
                        System.out.print("Enter new department: ");
                        department = sc.next();
                        System.out.print("Enter new salary: ");
                        salary = sc.nextDouble();
                        db.updateEmployee(id1,name,department,salary);
                        break;
                       
                    case 3:
                    	System.out.print("Enter employee ID to view: ");
                        int viewId = sc.nextInt();
                        Employee employee1 = db.ViewEmployee(viewId);
                        if (employee1 != null) {
                            System.out.println("ID: " + employee1.getId());
                            System.out.println("Name: " + employee1.getName());
                            System.out.println("Age:" +employee1.getAge());
                            System.out.println("Designation:"+employee1.getDesiganation());
                            System.out.println("Department: " + employee1.getDepartment());
                            System.out.println("Salary: " + employee1.getSalary());
                        } else {
                            System.out.println("Employee not found!");
                        }
                        break;
	                    
	                case 4:
	                	System.out.print("Enter employee ID to delete: ");
                        int deleteId = sc.nextInt();
                        db.deleteEmployee(deleteId);
                        	break;
	                case 5:
	                	 List<Employee> employees = db.ViewtAllEmployee();
	                	 System.out.println("Employee List:");
	                	 for (Employee employee : employees) {
	                		 System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() +", + Age: " + employee.getAge() +",  +Designation :" +employee.getDesiganation()+
                                   ", Department: " + employee.getDepartment() + ", Salary: " + employee.getSalary());
	                }
         
	                    break;
	                case 6:
	                	System.out.println("Thank you using for Application");
	                    System.exit(0);
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	                   
	            }
	        }
	    } 
	    else 
	    {
	        System.out.println("Invalid username or password.");
	    }
	    
	}

	}



