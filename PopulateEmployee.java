package populatedb;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PopulateEmployee {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/fleet_management?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";
	
	String inputFile = "E:/SRH_HOCHSCHULE_HEIDELBERG_MS_ACS/SDP_2017/Fleet Management/employee.txt";
	
	public static void main(String[] args) {
		PopulateEmployee pe = new PopulateEmployee();
		pe.readFile();
	}
	
	public void readFile() {
		
		BufferedReader br = null;
		String[] aList = new String[9];
		
		try {
			
			String currentLine;
			br = new BufferedReader(new FileReader(inputFile));
			
			while((currentLine = br.readLine()) != null) {
				
				aList = currentLine.split(",");
				
				String sql = "INSERT INTO employee (fname,lname,email,pass,phone,street,city,pincode,role) VALUES('"
						+aList[0]+"','"+aList[1]+"','"+aList[2]+"','"+aList[3]+"','"+aList[4]+"','"+aList[5]+"','"+aList[6]+"','"+aList[7]+"','"+aList[8]+"');";
				
				System.out.println(currentLine);
				
				int empId = addEmployeeToDB(sql);
				System.out.println("employee id is: "+empId);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int addEmployeeToDB(String sql) {
		
		Connection conn = null;
		Statement stmt = null;
		int empId = 0;
		
		try {
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			System.out.println(result);
			
			String sql2 = "SELECT MAX(emp_id) FROM employee;";
			ResultSet rs = stmt.executeQuery(sql2);
			
			while (rs.next()) {
				empId = rs.getInt("max(emp_id)");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return empId;
	}
	
public static boolean removeEmployeeFromDB(int empId) {
		
		boolean success = false;
		String sql = "DELETE FROM employee WHERE emp_id = " + empId + ";";
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
