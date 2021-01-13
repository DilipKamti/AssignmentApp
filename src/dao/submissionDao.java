package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import model.submission_pojo;

public class submissionDao 
{

	public String submission(submission_pojo pojo) 
	{
		System.out.println(pojo.getId());
		System.out.println(pojo.getDetail());
		
		String sql="select * from assignments a inner join student_details s on a.stream=s.dept and a.year=s.year inner join teacher_details t on a.t_id =t.t_id where s.s_id =?";
		String sql1="INSERT INTO submission_table (s_id ,t_id , stream ,year,submission_date,details,a_id)VALUES(?,?,?,?,?,?,?)";
		String dburl="jdbc:mysql://localhost:3306/assignment";
	  	String dbname="root";
	  	String dbpass="1234";
		Connection con=null;
	  	PreparedStatement stmt=null;
	  	PreparedStatement stmt1=null;
		ResultSet rs=null;
		int rs1=0;
		//String k=null;
		String l=null;
		String m=null;
		String n=null;
		String date=java.time.LocalDate.now().toString();
	//	String Date=date.toString();
		try
	  	{
		  		Class.forName("com.mysql.jdbc.Driver");
		  		con=DriverManager.getConnection(dburl,dbname,dbpass);
		  		stmt=con.prepareStatement(sql);
		  		stmt.setString(1, pojo.getId());
				System.out.println(stmt);
				rs=stmt.executeQuery();
				if (rs.next())
			    {

					 m=rs.getString("stream");
					 n=rs.getString("year");
				  		System.out.println(m);
				  		System.out.println(n);
			    }
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("Data didn't retrived");
	  	
	  		System.out.println(m);
	  		System.out.println(n);
	  		System.out.println(e);
	  	}
		try
	  	{
		  		Class.forName("com.mysql.jdbc.Driver");
		  		con=DriverManager.getConnection(dburl,dbname,dbpass);
		  		stmt1=con.prepareStatement(sql1);
		  		stmt1.setString(1, pojo.getId());
		  		stmt1.setString(2, pojo.getTid());
		  		stmt1.setString(3, m);
		  		stmt1.setString(4, n);
		  		stmt1.setString(5, date);
		  		stmt1.setString(6, pojo.getDetail());
		  		stmt1.setString(7, pojo.getAid());
				System.out.println(stmt1);
				rs1=stmt1.executeUpdate();
				if (rs1==1)
			    {
					return "success";
			    }
					
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println(e);
	  	}
  
		
		return "failed";
	}
    
}
