package edu.ilstu.it353;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID= request.getParameter("userID");
		String password = request.getParameter("password");
		
		String errorMessage = "";
		
		User user = null;
		
		UserEntryHelper helper = new UserEntryHelper();
		
	
		try 
		{
			user = helper.matchPassword(userID, password);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			if(user.getUserID()!=null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				forward(request, response, "/index.jsp");
				
				
			}
			
			else
			{
				errorMessage = "Invalid UserID or Password";
				request.setAttribute("errorMessage", errorMessage);
				forward(request, response, "/logIn.jsp");
			}
		
		
		
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException
	{
		ServletContext context = request.getServletContext();

		RequestDispatcher dispatcher = context.getRequestDispatcher(path);

		dispatcher.forward(request, response);
	}

}
