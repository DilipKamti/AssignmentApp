package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.viewDao;
import model.viewBean;

@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;

    viewDao dao=new viewDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String assignmentId=request.getParameter("AssignmentId");
		System.out.println(assignmentId);
		
		ArrayList<viewBean> s=dao.list(assignmentId);
		
	    session.setAttribute("submissionList", s);
	    
	    
	    response.sendRedirect("view.jsp");
	}

}
