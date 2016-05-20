package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.BookDao;
import dto.BookDTO;


@WebServlet("/ShowBooks")
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BookDao dao;
       
   List<BookDTO> books = new ArrayList<BookDTO>();
   
    public ShowBooks() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside show books method");
		dao= new BookDao();
		
		try {
			dao.openConnection();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		try (PrintWriter out = response.getWriter()){
			books = dao.showTableData();
		
			out.println("<table border=1>");
	         for (BookDTO bookDTO : books) {
				out.println("<tr><td>" +bookDTO.getBookid() +"</td>"+ "<td>" +bookDTO.getBooktitle() +"</td>" +"<td>" +bookDTO.getBookauthor() +"</td>" + "<td>" +bookDTO.getBookreview()+"</td>" +"<td>" +bookDTO.getBookprice() +"</td></tr>");
				
	        	 
			}
	         out.println("<form action ='LogoutServlet'>");
		     	out.println("<input type='button' value='Logout'>");
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
