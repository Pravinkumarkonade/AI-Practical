package fleetmanagement;

import java.io.*;
import java.util.*;

/**
 * The login class. This class is called at the start of the application when the user
 * first tries to login to the fleet management system.
 * 
 * @author Karan Milind Vichare
 * 
 * 
 *
 */
public class Login {
	
	private String username; //Variable to store the username of a user.
	private String password; //Variable to store the password of the user.
	
	/*The method to be called for validating a user login.*/
	public void userLogin() {
		
		try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	        
	        System.out.print("USERNAME: ");
	        username = reader.readLine();
	        while(username.equals("")||username==null) {
	        	System.out.print("Please enter a valid USERNAME:");
	        	username = reader.readLine();
	        }
	        System.out.print("PASSWORD: ");
	        password = reader.readLine();
	        while(password.equals("")||password==null) {
	        	System.out.print("Please enter a valid PASSWORD:");
	        	password = reader.readLine();
	        }
	        
	        System.out.println("Your username is: " + username);
	        System.out.println("Your password is: " + password);
	        
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    }
	}

}
