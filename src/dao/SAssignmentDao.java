package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.SAssignmentBean;

public class SAssignmentDao 
{
	
	public ArrayList<SAssignmentBean> list (String id)
	{
		ArrayList<SAssignmentBean> a=new ArrayList<SAssignmentBean>();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select t.name,t.t_id,a.stream,a.year,a.assignments_details,a.starting_date,a.last_date,a.a_id from assignments a inner join student_details s on a.stream=s.dept and a.year=s.year inner join teacher_details t on a.t_id =t.t_id where s.s_id =?"; 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","1234");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("name");
				String t_id=rs.getString("t_id");
				String stream=rs.getString("stream");
				String year=rs.getString("year");
				String details=rs.getString("assignments_details");
				String start_date=rs.getString("starting_date");
				String last_date=rs.getString("last_date");
				String a_id=rs.getString("a_id");
			
				
				SAssignmentBean bean =new SAssignmentBean();
				bean.setName(name);
				bean.setId(t_id);
				bean.setDetails(details);
				bean.setStream(stream);
				bean.setYear(year);
				bean.setStart_date(start_date);
				bean.setLast_date(last_date);
				bean.setA_id(a_id);
				
				a.add(bean);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return a;
	}

}
