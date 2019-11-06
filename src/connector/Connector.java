package connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	private Connection connect;
	private static Connector instance = new Connector();
	
	public Connector() {
		this.connect = null;
		
	}
	
	public boolean login(String id, String password) {
		try{
//			Class.forName("com.mysql.jdbc.Driver");
			String url = String.format("jdbc:mysql://localhost/testdb?user=%s&password=%s",id,password);
//			System.out.println(url);
			connect = DriverManager.getConnection(url);
			System.out.println("TRY");
			
			if (connect != null) {
				System.out.println("Login Success");
				return true;
			}
			else {
				System.out.println("Login Failed");
				return false;
			}
		}catch (Exception e) {
			System.out.println("Catch");
			System.out.println("Login Failed: Wrong Username or Password");
		}
		
		
		return false;
	}

	public Connection getConnect() {
		return connect;
	}

	public static Connector getInstance() {
		return instance;
	}
	
	

}
