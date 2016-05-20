package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BookDao;



@WebServlet("/ShowDetailsOfSelectedBooks")
public class ShowDetailsOfSelectedBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowDetailsOfSelectedBooks() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String[] bookid= request.getParameterValues("books");
		
		BookDao dao = new BookDao();
		ResultSet rs;
		try {
		dao.openConnection();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		for (String string : bookid) {
			try {
				 rs = dao.ShowDetailsOfSelectedBooks(string);
				 out.println("<table border=1>");
		         while(rs.next())
		        	
		         	 
		         {
		        	 out.println("<tr><td>"+rs.getInt(1)+"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>"
		        			 +rs.getString(4) +"</td><td>" +rs.getInt(5) +"</td> </tr>");
		        			 		
		             
		      
		         }
		         out.println("<form action ='LogoutServlet'>");
		     	out.println("<input type='button' value='Logout'>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
		}
		
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
