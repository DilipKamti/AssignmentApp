package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.submittedDao;
import model.submittedBean;




@WebServlet("/submitted")
public class submitted extends HttpServlet {
	private static final long serialVersionUID = 1L;
     submittedDao dao=new submittedDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		System.out.println(id);
		ArrayList<submittedBean> s=dao.list(id);
		
	    session.setAttribute("submittedList", s);
	    
	    
	    response.sendRedirect("Submitted.jsp");
	}

}
