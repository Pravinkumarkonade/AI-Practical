package populatedb;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PopulateVehicle {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/fleet_management?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";
	
	String inputFile = "E:/SRH_HOCHSCHULE_HEIDELBERG_MS_ACS/SDP_2017/Fleet Management/vehicle.txt";
	
	public static void main(String[] args) {
		PopulateVehicle pv = new PopulateVehicle();
		pv.readFile();
	}
	
	public void readFile() {
		
		BufferedReader br = null;
		String[] aList = new String[6];
		
		try {
			
			String currentLine;
			br = new BufferedReader(new FileReader(inputFile));
			
			while((currentLine = br.readLine()) != null) {
				
				aList = currentLine.split(",");
						
				String sql = "INSERT INTO vehicle (model, brand, reg_no, year, pax, category) VALUES('"
						+aList[0]+"','"+aList[1]+"','"+aList[2]+"',"+Integer.parseInt(aList[3])+","+Integer.parseInt(aList[4])+",'"+aList[5]+"');";
				
				System.out.println(currentLine);
				
				int vehId = addVehicleToDB(sql);
				System.out.println("vehicle id is: "+vehId);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int addVehicleToDB(String sql) {
		
		Connection conn = null;
		Statement stmt = null;
		int vehId = 0;
		
		try {
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			String sql2 = "SELECT MAX(veh_id) FROM vehicle;";
			ResultSet rs = stmt.executeQuery(sql2);
			
			while (rs.next()) {
				vehId = rs.getInt("max(veh_id)");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return vehId;
	}
	
	public static boolean removeVehicleFromDB(int vehId) {
		
		boolean success = false;
		String sql = "DELETE FROM vehicle WHERE veh_id = " + vehId + ";";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			success = true;
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}

}
