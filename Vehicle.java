package fleetmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import populatedb.PopulateVehicle;


public class Vehicle {
	
	private int vehId;
	private String model;
	private String brand;
	private String regNo;
	private int year;
	private int pax;
	private String category;

	
	public void addVehicle() {
		
		try {
			
			System.out.println("Add a new vehicle");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter vehicle model: ");
	        model = reader.readLine();
	        
	        System.out.print("Enter vehicle brand: ");
	        brand = reader.readLine();
	        
	        System.out.print("Enter vehicle registration number: ");
	        regNo = reader.readLine();
	        
	        System.out.print("Enter vehicle year of manufacture: ");
	        year = Integer.parseInt(reader.readLine());
	        
	        System.out.print("Enter vehicle number of passenger capacity: ");
	        pax = Integer.parseInt(reader.readLine());
	        
	        System.out.print("Enter vehicle category: ");
	        category = reader.readLine();
	        
	        String sql = "INSERT INTO vehicle (model, brand, reg_no, year, pax, category) VALUES('"
					+model+"','"+brand+"','"+regNo+"',"+year+","+pax+",'"+category+"');";
	        
	        vehId = PopulateVehicle.addVehicleToDB(sql);
	        System.out.println("Vehicle ID is: "+vehId);
	        
		} catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}
	
	public void deleteVehicle(int vehId) {
		
		boolean success = PopulateVehicle.removeVehicleFromDB(vehId);
		System.out.println("Vehicle record successfully removed :"+success);
		
	}

}
