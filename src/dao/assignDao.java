package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

import model.assign;
public class assignDao
{
    public String assignSubmit(assign as)
    {
    	String sql1="INSERT INTO assignments (t_id, stream, year , assignments_details , starting_date, last_date,a_id)VALUES(?,?,?,?,?,?,?)";
		String dburl="jdbc:mysql://localhost:3306/assignment";
	  	String dbname="root";
	  	String dbpass="1234";
		Connection con=null;
	  	PreparedStatement stmt=null;
		int rs=0;
		String id = UUID.randomUUID().toString();
	  	id = id.replaceAll("-", "");
	  	try
	  	{
		  		Class.forName("com.mysql.jdbc.Driver");
		  		con=DriverManager.getConnection(dburl,dbname,dbpass);
		  		stmt=con.prepareStatement(sql1);
		  		stmt.setString(1, as.getId());
				stmt.setString(2, as.getStream());
				stmt.setString(3, as.getYear());
				stmt.setString(4, as.getWrite());
				stmt.setString(5, as.getStart());
				stmt.setString(6, as.getLast());
				stmt.setString(7, id);
				System.out.println(stmt);
				rs=stmt.executeUpdate();
				if (rs!=0)
			    {
		             return "SUCCESS";
			    }
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println(e);
	  	}
    	
    	return "Something went wrong plzz try again";
    }
}
