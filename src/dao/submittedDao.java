package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.submittedBean;

public class submittedDao
{
	public ArrayList<submittedBean> list(String id) 
	{
		ArrayList<submittedBean> a=new ArrayList<submittedBean>();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select td.name, st.stream, st.year,a.assignments_details ,st.details ,a.starting_date ,st.submission_date from assignments a inner join submission_table st on a.a_id = st.a_id inner join teacher_details td on st.t_id = td.t_id where st.s_id =?"; 
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
				String stream=rs.getString("stream");
				String year=rs.getString("year");
				String details=rs.getString("assignments_details");
				String start_date=rs.getString("starting_date");
				String submission_details=rs.getString("details");
				String submission_date=rs.getString("submission_date");
				
				System.out.println(name);
				System.out.println(stream);
				System.out.println(year);
				System.out.println(details);
				System.out.println(start_date);
				System.out.println(submission_details);
				System.out.println(submission_date);
				
				submittedBean bean =new submittedBean();
				bean.setName(name);
				bean.setStream(stream);
				bean.setYear(year);
				bean.setAssignDetail(details);
				bean.setAssignDate(start_date);
				bean.setSubmissionDetail(submission_details);
				bean.setSubmissionDate(submission_date);
				
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
