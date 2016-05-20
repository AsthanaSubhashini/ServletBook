package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dto.LoginDTO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("UserName");
		String password= request.getParameter("Password");
		
		LoginDao dao=null;
		try
		{
			LoginDTO dto = new LoginDTO(username,password);
			dao=new LoginDao();
			dao.openConnection();
			if(dao.Validate(dto))
			{
				if(dto.getUsername().equalsIgnoreCase("admin") && dto.getPassword().equalsIgnoreCase("admin"))
				{
					System.out.println("inside admin method");
					HttpSession session = request.getSession();
					session.setAttribute("USERNAME",username);
					/*Cookie cookie = new Cookie("username",username);
					response.addCookie(cookie);
					 */
					
					//If username is admin & password is admin..forward the request to Admin Page
					RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPage");
					dispatcher.forward(request, response);
				}
				
				else
				{
				
				//Cookie
				Cookie cookie = new Cookie("username",username);
				response.addCookie(cookie);
				// Creating Session
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				//forwading the request to User Servlet Page
				RequestDispatcher dispatcher = request.getRequestDispatcher("UserServlet");
				dispatcher.forward(request, response);
				}
			}
			else
			{
				response.setContentType("text/html");
				try(PrintWriter out = response.getWriter())
				{
					out.println("<html");
					out.println("<head>");
					out.println("<body>");
					out.println("<title>WELCOME TO CYBAGENET </title>");
					out.println("</head");
					out.println("<h3> Invalid username or password</h3>");
					out.println("<a href='index.html'>Login again</a>");
					out.println("</body>");
					out.println("</html>");
				}
			}
		
				}catch(Exception e)
				{
					e.printStackTrace();
				}finally
				{
					if(dao!=null)
					{
						dao.closeConnection();
					}
				}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
