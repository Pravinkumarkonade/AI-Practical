package fleetmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import populatedb.PopulateEmployee;

public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String street;
	private String city;
	private String pincode;
	private String role;
	

	public void addEmployee() {
		
		try {
			
			System.out.println("Add a new employee");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter firstName: ");
			firstName = reader.readLine();
	        
	        System.out.print("Enter lastName: ");
	        lastName = reader.readLine();
	        
	        System.out.print("Enter email: ");
	        email = reader.readLine();
	        
	        System.out.print("Enter password: ");
	        password = reader.readLine();
	        
	        System.out.print("Enter phone number: ");
	        phone = reader.readLine();
	        
	        System.out.print("Enter street address: ");
	        street = reader.readLine();
	        
	        System.out.print("Enter city: ");
	        city = reader.readLine();
	        
	        System.out.print("Enter pincode: ");
	        pincode = reader.readLine();
	        
	        System.out.print("Enter employee designation: ");
	        role = reader.readLine();
	        
	        String sql = "INSERT INTO employee (fname,lname,email,pass,phone,street,city,pincode,role) VALUES('"
					+firstName+"','"+lastName+"','"+email+"','"+password+"','"+phone+"','"+street+"','"+city+"','"+pincode+"','"+role+"');";
	        
	        empId = PopulateEmployee.addEmployeeToDB(sql);
	        System.out.println("Employee ID is: "+empId);
	        
		} catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}
	
	public void deleteEmployee(int empId) {
		
		boolean success = PopulateEmployee.removeEmployeeFromDB(empId);
		System.out.println("Employee record successfully removed :"+success);
		
	}

}
