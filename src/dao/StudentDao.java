package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import model.StudentPojo;

public class StudentDao {

	public String studentregister(StudentPojo pojo)
	{
		String sql="insert into student_details (s_id ,name ,username ,password ,email ,dept ,year ,rollno ) values (?,?,?,?,?,?,?,?)";
	 	String sql1="insert into user_auth(username, password, user_id, user_type) VALUES(?,?,?,?)";
		String dburl="jdbc:mysql://localhost:3306/assignment";
	  	String dbname="root";
	  	String dbpass="1234";
		Connection con=null;
	  	PreparedStatement stmt=null;
	  	PreparedStatement stmt1=null;
	  	/*String id = UUID.randomUUID().toString();
	  	id = id.replaceAll("-", "");*/
	  	int rs=0;
	  	int rs1=0;
	    String s="Student";
	  	 try
		  {
	  		  Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(dburl,dbname,dbpass);
				stmt=con.prepareStatement(sql);
				stmt1=con.prepareStatement(sql1);
				stmt.setString(1, pojo.getId());
				stmt.setString(2, pojo.getName());
				stmt.setString(3, pojo.getUseranme());
				stmt.setString(4, pojo.getPassword());
				stmt.setString(5, pojo.getEmail());
				stmt.setString(6, pojo.getDepertment());
				stmt.setString(7, pojo.getYear());
				stmt.setString(8, pojo.getRollno());
				
				stmt1.setString(1, pojo.getUseranme());
				stmt1.setString(2, pojo.getPassword());
				stmt1.setString(3, pojo.getId());
				stmt1.setString(4, s);
				
				
				System.out.println(stmt);
				System.out.println(stmt1);
			    rs=stmt.executeUpdate();
			    rs1=stmt1.executeUpdate();
			    if (rs!=0 && rs1!=0)
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
