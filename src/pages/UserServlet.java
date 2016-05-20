package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside subjects servlet");
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		
		
		out.println("<a href=BookSearch.html>Book Search</a>");
		out.println("<a href=SelectBookServlet>Show Books </a>");
		out.println("<a href=AddReview.html> Add Review</a>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.println("<form action ='LogoutServlet'>");
		out.println("<input type='button' value='Logout'>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
