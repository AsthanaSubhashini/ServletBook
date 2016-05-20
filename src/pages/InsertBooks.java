package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.BookDTO;


@WebServlet("/InsertBooks")
public class InsertBooks extends HttpServlet {
	BookDao dao = new BookDao();
	private static final long serialVersionUID = 1L;
       
   
    public InsertBooks() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside insert new books servlet");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String id=request.getParameter("bookid");
		String title=request.getParameter("booktitle");
		String author=request.getParameter("bookauthor");
		String review = request.getParameter("bookreview");
		String price =request.getParameter("bookprice");
		BookDao dao = null;
		
		try
		{
			BookDTO dto = new BookDTO(Integer.parseInt(id),title,author,review,Integer.parseInt(price));
			dao=new BookDao();
			dao.openConnection();
			
			if(dao.insertBook(dto)==1)
			{
				System.out.println("Successfully Inserted");
				out.println("Record Successfully Inserted");
				out.println("<form action ='ShowBooks'>");
				out.println("<input type='submit' value='Show Table'>");
				
				out.println("</form>");
			}
			out.println("<form action ='LogoutServlet'>");
			out.println("<input type='button' value='Logout'>");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
