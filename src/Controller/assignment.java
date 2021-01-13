package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.assignDao;
import model.assign;

@WebServlet("/assignment")
public class assignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	assignDao dao=new assignDao();
       
    public assignment() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession  session=request.getSession();
		String stream=request.getParameter("stream");
		String year=request.getParameter("year");
		String write=request.getParameter("write");
		String start=request.getParameter("start");
		String last=request.getParameter("last");
		System.out.println(session.getAttribute("id"));
		
		assign as=new assign();
        as.setId((String)session.getAttribute("id"));
		as.setStream(stream);
		as.setYear(year);
		as.setWrite(write);
		as.setStart(start);
		as.setLast(last);
		
		String s =dao.assignSubmit(as);
        
		 if(s.equals("SUCCESS"))  
        {
			 response.sendRedirect("Assignment.jsp");
        }
        else   
        {
         System.out.println("Assignment failed to given");
        }
		
	}

}
