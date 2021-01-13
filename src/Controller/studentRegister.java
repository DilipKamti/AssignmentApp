package Controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import model.StudentPojo;

@WebServlet("/studentRegister")
public class studentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao dao = new StudentDao();
       
    public studentRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String dept=request.getParameter("dept");
		String year=request.getParameter("year");
		String roll=request.getParameter("roll");
		
		String id = UUID.randomUUID().toString();
	  	id = id.replaceAll("-", "");
		
		StudentPojo pojo=new StudentPojo();
		
		pojo.setName(name);
		pojo.setUseranme(username);
		pojo.setEmail(email);
		pojo.setPassword(password);
		pojo.setDepertment(dept);
		pojo.setYear(year);
		pojo.setRollno(roll);
		pojo.setId(id);
		

		String student =dao.studentregister(pojo);
        
		 if(student.equals("SUCCESS"))  
         {
			 response.sendRedirect("StudentHome.jsp");
         }
         else   
         {
          response.sendRedirect("registrationFailed.jsp");
         }
		
	}

}
