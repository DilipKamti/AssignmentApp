package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.viewBean;
public class viewDao 
{
	public ArrayList<viewBean> list(String assignmentId)
	{
		ArrayList<viewBean> a=new ArrayList<viewBean>();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select stu.name,stu.dept,stu.year,st.details,st.submission_date from assignments a inner join submission_table st on a.a_id = st.a_id inner join student_details stu on st.s_id = stu.s_id where a.a_id = ?"; 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","1234");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, assignmentId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("name");
				String stream=rs.getString("dept");
				String year=rs.getString("year");
				String details=rs.getString("details");
				String date=rs.getString("submission_date");
				
				System.out.println(name);
				System.out.println(stream);
				System.out.println(year);
				System.out.println(details);
				System.out.println(date);
				 
				
				viewBean bean =new viewBean();
				bean.setName(name);
				bean.setStream(stream);
				bean.setYear(year);
				bean.setAssignmentDetails(details);
				bean.setSubmissionDate(date);
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
