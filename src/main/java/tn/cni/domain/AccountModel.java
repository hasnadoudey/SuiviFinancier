package tn.cni.domain;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class AccountModel {

	
		
		  
	public boolean login(String username, String password){
	    String query;
	    boolean login = false;

	    try {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cniproject", "root", "root");
	        Statement stmt = (Statement) con.createStatement();
	        query = "SELECT username, password FROM account WHERE username='" + username + "' AND password='" + password + "';";
	        stmt.executeQuery(query);
	        ResultSet rs = stmt.getResultSet();
	        login = rs.first(); 
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return login;
	}
			 
		
		
}
