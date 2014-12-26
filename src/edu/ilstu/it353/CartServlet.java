package edu.ilstu.it353;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		boolean merged = false;
		if(user==null)
		{
			forward(request, response, "/logIn.jsp");
		}
		else
		{
			
			String userID= user.getUserID();
			int itemID = Integer.parseInt(request.getParameter("itemID"));
			CartHelper helper = new CartHelper();
			try 
			{
				merged = helper.insertItem(userID, itemID);
				if(merged)
				{
					forward(request, response, "/myCart.jsp");
				}
				else
				{
					forward(request, response, "/error.jsp");
				}
			}
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			
		}
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException
	{
		ServletContext context = request.getServletContext();

		RequestDispatcher dispatcher = context.getRequestDispatcher(path);

		dispatcher.forward(request, response);
	}

}
