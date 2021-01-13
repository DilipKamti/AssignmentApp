package Controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.loginDao;
import model.idTypeBean;
import model.loginPojo;

@WebServlet("/login")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private loginDao dao;
       
	public void init()
    {
    	dao=new loginDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		loginPojo pojo=new loginPojo();
    	pojo.setUsername(u);
    	pojo.setPassword(p);
    	idTypeBean s=null;

    	HttpSession session=request.getSession();
       try
		{
    	    s= dao.studentlogin(pojo);

       		String id=s.getId();
       		String type=s.getType();
			if(type.equals("Student"))
			{
				session.setAttribute("id", id);
				 session.setAttribute("username",u);
				 response.sendRedirect("StudentHome.jsp");
				 
			}
			else if(type.equals("Teacher"))
			{
			     session.setAttribute("username",u);
			     session.setAttribute("id", id);
				response.sendRedirect("TeacherHome.jsp");			
			}
		}
		catch (Exception e) 
		{
			response.sendRedirect("LoginFailed.jsp");
		}
	}

}
