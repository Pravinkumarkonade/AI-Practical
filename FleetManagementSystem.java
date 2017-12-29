package fleetmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FleetManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Login login = new Login();
//		login.userLogin();
		
//		Vehicle veh = new Vehicle();
//		veh.addVehicle();
		
		Employee emp = new Employee();
		emp.addEmployee();
		
		System.out.println("enter employee id to delete: ");
		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter employee ID: ");
	        int id = Integer.parseInt(reader.readLine());
//	        veh.deleteVehicle(id);
	        emp.deleteEmployee(id);
	        
		}catch (IOException ioe) {
	        ioe.printStackTrace();
	    }

	}

}
