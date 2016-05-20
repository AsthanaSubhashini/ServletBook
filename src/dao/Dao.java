package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private String DB_URL="jdbc:mysql://localhost/mydb";
	private String DB_USER="root";
	private String DB_PASS="root";
	Connection connection;
	static 
	{
		try
		{
			System.out.println("Inside DAO");
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void openConnection() throws SQLException
	{
		if(this.connection== null)
		this.connection =DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
	}
	
	public void closeConnection()
	{
		try
		{
		if(this.connection!=null)
		
			this.connection.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
