package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.BookDTO;


@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddReviewServlet() {
        super();
    }
        

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Inside Add review Servlet");
		PrintWriter out = response.getWriter();
		
		String bookname = request.getParameter("Bookname");
		String review   =   request.getParameter("review");
		
		BookDao dao = new BookDao();
		try {
			dao.openConnection();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		BookDTO dto=new BookDTO();;
		try {
			
			if(dao.BookReview(review, bookname))
			{
				
				out.println(dto.getBookreview());
				out.println("Review Added Successfully");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		/*out.println("<form>");
		out.println("<div align='center'>");
		out.println("Enter Book name to add review");
		out.printf("<input type='text' name='bookname'>");
		out.println("<br>");
		out.println("<br>");
		out.println("Write Your reviews here");
		out.printf("<input type='text' name='review'>");
		out.println("<br>");
		out.println("<br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</div>");
		out.println("</form>");*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
