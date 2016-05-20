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



@WebServlet("/SelectBookServlet")
public class SelectBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectBookServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookDao dao = new BookDao();
		PrintWriter out = response.getWriter();
		System.out.println("Inside select books servlet");	
		List<String> list = new ArrayList<String>(); 
		
		try {
		dao.openConnection();
		list = dao.getBookTitle();
		
	
		} 	catch (SQLException e) {
		
		e.printStackTrace();
		}
		
		
		out.println("<form action='ShowDetailsOfSelectedBooks'>");
		for (String string : list) {
		
		out.println("<input type='checkbox' name='books' value='"+string+"'>"+string);
		
		//out.println(string.toString());
		
		
		}
		out.println("<input type='submit' value ='ShowDetails'");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("ShowDetailsOfSelectedBooks");
		//dispatcher.forward(request, response);
		out.println("</form>");
		
		}
		
		
		
		
		
		//out.println("<a href='ShowDetailsOfSelectedBooks'>Show Details</button>");
		
		/*try {
			ResultSet rs = dao.ShowDetailsOfSelectedBooks(dto.getBookid());
			out.println("<table border=1>");
	         while(rs.next())
	        	
	         	 
	         {
	        	 out.println("<tr><td>"+rs.getInt(1)+"</td><td>" +rs.getString(2)+"</td><td>" +rs.getString(3) +"</td><td>"
	        			 +rs.getString(4) +"</td><td>" +rs.getInt(5) +"</td> </tr><input type =radio value=text");
	        			 		
	             
	      
	         }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		
	
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
