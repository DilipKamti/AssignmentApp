package Controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TeacherDao;
import model.TeacherPojo;


@WebServlet("/RegisterServlet")
public class teacherRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao dao = new TeacherDao();
       
    public teacherRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fac=request.getParameter("dept");
		String cont=request.getParameter("contact");
		
		String id = UUID.randomUUID().toString();
	  	id = id.replaceAll("-", "");
		
		TeacherPojo pojo=new TeacherPojo();
		
		pojo.setName(name);
		pojo.setUseranme(username);
		pojo.setEmail(email);
		pojo.setPassword(password);
		pojo.setFaculty(fac);
		pojo.setContact(cont);
		pojo.setId(id);
		
		

		String teacher =dao.teacherregister(pojo);
        
		 if(teacher.equals("SUCCESS"))  
         {
			 response.sendRedirect("TeacherHome.jsp");
         }
         else   
         {
          response.sendRedirect("registrationFailed.jsp");
         }
	}

}
