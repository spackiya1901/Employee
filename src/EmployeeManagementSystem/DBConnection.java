package EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	    static Connection con;
	    public static Connection createDBConnetion(){

	        try{
	            
	        	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydatabase","root","packiya");


	        }catch (Exception ex){
	            ex.printStackTrace();
	        }
	     return con;

	    }
		public static Connection getConnection() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	


