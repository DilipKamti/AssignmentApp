package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.submissionDao;
import model.submission_pojo;

@WebServlet("/submissionController")
public class submissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private submissionDao dao=new submissionDao();
    public submissionController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession  session=request.getSession();
		String id=(String)session.getAttribute("id");
		String s=request.getParameter("write");
		String tid=request.getParameter("tid");
		String aid=request.getParameter("aid");
		
		System.out.println("Student id "+id);
		System.out.println(s);
		System.out.println("teacher id "+tid);
		System.out.println("assignment id "+aid);
		
		submission_pojo pojo=new submission_pojo();
		pojo.setId(id);
		pojo.setDetail(s);
		pojo.setTid(tid);
		pojo.setAid(aid);
		
		String s2=dao.submission(pojo);
		
		if(s2.equals("success"))
		{
			response.sendRedirect("SAssignmentList.jsp");
		}
		else
		{
			response.sendRedirect("uploadAssignment.jsp");
		}
	}

}
