package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;


@WebServlet("/BooksSearchServlet")
public class BooksSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BooksSearchServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside books search servlet ");
		PrintWriter out = response.getWriter();
		String book_name= request.getParameter("BookName");
		
		BookDao dao  = new BookDao();
		try {
			dao.openConnection();
			ResultSet rs= dao.BookSearch(book_name);
		
			out.println("<table border=1>");
			while(rs.next())
       	
        	 
			{
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>"
       			 +rs.getString(4) +"</td><td>" +rs.getInt(5) +"</td> </tr><input type =radio value=text");
       			 		
            
     
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
