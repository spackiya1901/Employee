package EmployeeManagementSystem;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	public class Database{
	   
	    Connection con;
		private String name;
		private String designation;
		private double salary;
		private int id;
	  
		public void AddEmployee(Employee emp) throws ClassNotFoundException, SQLException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydatabase","root","packiya");
			System.out.println(con);
	        String sql = "INSERT INTO employees(name, age, designation, department, salary) VALUES ( ?, ?, ?, ?,?);";
	        try {
	             PreparedStatement pstmt = con.prepareStatement(sql);
//	            pstmt.setInt(1,emp.getId());
	            pstmt.setString(1, emp.getName());
	            pstmt.setInt(2, emp.getAge());
	            pstmt.setString(3, emp.getDesiganation());
	            pstmt.setString(4,emp.getDepartment());
	            pstmt.setDouble(5, emp.getSalary());
	            int n = pstmt.executeUpdate();
	            if (n > 0) {
	                System.out.println("A new employee was inserted successfully!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		 public Employee ViewEmployee(int id) throws ClassNotFoundException, SQLException {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydatabase","root","packiya");
		        String query = "SELECT * FROM employees WHERE id = ?";
		       
		        	
		        
		             PreparedStatement stmt = con.prepareStatement(query);
		            stmt.setInt(1, id);
		            try (ResultSet rs = stmt.executeQuery()) {
		                if (rs.next()) {
		                    return new Employee(
		                            rs.getInt("id"),
		                            rs.getString("name"),
		                            rs.getInt("age"),
		                            rs.getString("department"),
		                            rs.getString("designation"),
		                            rs.getDouble("salary")
		                    );
		                }
		            
		        } catch (SQLException e) {
		           e.printStackTrace();
		        }
		        return null;
		    }


	    public void updateEmployee(int id,String name,String department,double salary) throws ClassNotFoundException, SQLException {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydatabase","root","packiya");
	        String query = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?;";
	        try {
	        	
	        
	             PreparedStatement pstmt = con.prepareStatement(query);
	             
	            pstmt.setString(1,name);
	            pstmt.setString(2, department);
	            pstmt.setDouble(3, salary);
	            pstmt.setInt(4, id);
	            int n = pstmt.executeUpdate();
	            if (n > 0) {
	                System.out.println("Employee updated successfully!");
	            } else {
	                System.out.println("Employee Updated not succesfully");
	            }  
	             
	} catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	    

	
	 public void deleteEmployee(int id) throws ClassNotFoundException, SQLException 
	 {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydatabase","root","packiya");
	        String sql = "DELETE FROM employees WHERE id = ?";
	        try {
	             PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            int n= pstmt.executeUpdate();
	            if (n > 0) {
	                System.out.println("An employee was deleted successfully!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	    }
	    
	    public List<Employee> ViewtAllEmployee() throws SQLException, ClassNotFoundException {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydatabase","root","packiya");
	        List<Employee> employees = new ArrayList<>();
	        String query = "SELECT * FROM employees";
	        try {
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                employees.add(new Employee(
	                		 rs.getInt("id"),
	                         rs.getString("name"),
	                         rs.getInt("age"),
	                         rs.getString("designation"),
	                          rs.getString("department"),
	                          rs.getDouble("salary")
	                
	                ));
	            }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
			return employees;
	        
	    }
	    }
	
	            
	            
	
	            
	        
	     
	  
	
	


