package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminPage() {
        super();
       
    }
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside admin page");
		
		 PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("username" );
		HttpSession session = (HttpSession) request.getAttribute("USERNAME");
		out.println("Hello " +session);
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<a href='InsertBooks.html'>  Insert New Books");
		out.println("</br>");
		out.println("</br>");
		//out.println("</br>");
		out.println("<a href='UpdateBookInfo'> Update Book Inforamtion");
		out.println("</br>");
		out.println("</br>");
		out.println("<a href='DeleteBooks'> Delete Books ");
		out.println("</br>");
		out.println("</br>");

		out.println("<a href='SessionCount'>Check No Of Active Sessions");
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
