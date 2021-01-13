package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseConnection {
	
	private static String JDBC_DRIVER   = "com.mysql.jdbc.Driver";
	private static String JDBC_URL      = "jdbc:mysql://localhost:3306/assignment"; 
    private static String JDBC_USER     = "root";
    private static String JDBC_PASSWORD = "1234";
    private static Driver driver = null;
    
	public static Connection getConnection()
	{
		Connection con = null;
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
				 con=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				 con.setAutoCommit(false);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return con;
	}
	

	public static void close(Connection conn)
	{		
		try {
			if (conn != null)
			{
				conn.close();
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement stmt)
	{
		try {
			if (stmt != null)
			{
				stmt.close();
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs)
	{		 	
		try {
			if (rs != null)
			{
				rs.close();
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		 
	}
}
