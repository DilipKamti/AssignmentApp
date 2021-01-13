package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TAssignmentDao;
import model.TAssignmentBean;


@WebServlet("/TAssignment")
public class TAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TAssignmentDao dao=new TAssignmentDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
     HttpSession session =request.getSession();
		
		String id=(String)session.getAttribute("id");
		
		
		
		ArrayList<TAssignmentBean> s=dao.list(id);
		//System.out.println(s.get(0).getName());
	    session.setAttribute("teacherList", s);
	    
	    
	    response.sendRedirect("AssignmentList.jsp");
		
	}

}
