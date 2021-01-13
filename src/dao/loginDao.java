package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.databaseConnection;
import model.idTypeBean;
import model.loginPojo;

public class loginDao 
{
	public idTypeBean studentlogin(loginPojo pojo) throws Exception
	{
		idTypeBean pojo1=new idTypeBean();
		boolean status=false;
		String sql="select * from user_auth where username=? and password=?";
		Connection con=null;
	  	PreparedStatement stmt=null;
	  	ResultSet rs=null;
		  String t=null;
		  String f=null;
		  String id=null;
		try
		  {
			  	con=databaseConnection.getConnection();
				stmt = con.prepareStatement(sql);
				stmt.setString(1, pojo.getUsername());
				stmt.setString(2, pojo.getPassword());				
				rs=stmt.executeQuery();
				status=rs.next();
				
			if(status==true)
			{
				t=rs.getString("user_type");
			    id=rs.getString("user_id");
			    
			    pojo1.setType(t);
			    pojo1.setId(id);
				return pojo1;
			}	
		  }
		  catch(SQLException e)
		  {
			  System.out.println(e);
		  }
		  finally 
		  {
			  databaseConnection.close(stmt);
			  databaseConnection.close(con); 
		  }
		return pojo1;
		
			
	}
	}
