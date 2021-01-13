package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TAssignmentBean;

public class TAssignmentDao {
	public ArrayList<TAssignmentBean> list (String id)
	{
		ArrayList<TAssignmentBean> a=new ArrayList<TAssignmentBean>();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select stream,year,assignments_details,starting_date,last_date,a_id from assignments where t_id =?"; 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","1234");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				String stream=rs.getString("stream");
				String year=rs.getString("year");
				String details=rs.getString("assignments_details");
				String start_date=rs.getString("starting_date");
				String last_date=rs.getString("last_date");
				String aid=rs.getString("a_id"); 
				
				
				TAssignmentBean bean =new TAssignmentBean();
				bean.setDetails(details);
				bean.setStream(stream);
				bean.setYear(year);
				bean.setStart_date(start_date);
				bean.setLast_date(last_date);
				bean.setAid(aid);
				
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
