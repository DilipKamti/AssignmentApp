package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SAssignmentDao;
import model.SAssignmentBean;

@WebServlet("/SAssignment")
public class SAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SAssignmentDao dao=new SAssignmentDao();
    
    public SAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session =request.getSession();
		
		String id=(String)session.getAttribute("id");
		
		System.out.println(id);
		
		ArrayList<SAssignmentBean> s=dao.list(id);
		System.out.println(s.get(0).getName());
	    session.setAttribute("studentList", s);
	    
	    
	    response.sendRedirect("SAssignmentList.jsp");
		
	}

	

}
