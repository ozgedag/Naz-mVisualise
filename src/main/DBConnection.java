package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class DBConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:8889/db_nazimhikmet?useUnicode=true&characterEncoding=utf8";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	Connection conn = null;
	
	public DBConnection(){
		
	}
	
	
	public void startConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection(){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public ArrayList<String> selectBook() throws SQLException{
		this.startConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM book";
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<String> bookNames = new ArrayList<>();
		//System.out.println("QUERY");
		while(rs.next()){
			bookNames.add(rs.getString("Name"));	
		}
		/*for(int i=0;i<bookNames.size();i++){
			System.out.println(bookNames.get(i));
		}*/
		try {
			stmt.executeQuery(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.startConnection();
		return bookNames;
	}
	

	
}
