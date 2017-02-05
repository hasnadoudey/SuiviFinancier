package tn.cni.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQLConnectionOpenshift {

	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String BD_URL="jdbc:mysql://127.2.109.130:3306/suivievaluation";
	
	
	static final String USER="admindx9MKKk";
	static final String PASS="JmwfNnl-5PGN";
	
	public Connection getConnection() throws Exception{
		
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(BD_URL ,USER,PASS);
		}catch(ClassNotFoundException cEx){
			throw cEx;
		}catch(SQLException sEx){
			throw sEx;
		}
		System.out.println("Established Connection");
		return connection;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
