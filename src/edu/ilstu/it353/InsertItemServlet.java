package edu.ilstu.it353;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;



/**
 * Servlet implementation class InsertItemServlet
 */
@WebServlet("/InsertItemServlet")
@MultipartConfig(fileSizeThreshold=1024*1024, maxFileSize=1024*1024*8, maxRequestSize=1024*1024*32)


public class InsertItemServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final Pattern FILE_NAME_PATTERN = Pattern.compile("fileName=\"(.+)\"", Pattern.CASE_INSENSITIVE);
       

    public InsertItemServlet() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
			//String savePath = "./images";
			String fileName = null;
				//String savePath= "H:\\work\\M2_S2-GA\\images";
		 		String SAVE_DIR = "images"; 
		        String appPath = request.getServletContext().getRealPath("");
		        String savePath = appPath + File.separator + SAVE_DIR;
//		        System.out.println(savePath);
		         
			
	        File fileSaveDir = new File(savePath);
	        if (!fileSaveDir.exists()) 
	        {
	            fileSaveDir.mkdir();
	        }
	         String x = "";
	        for (Part part : request.getParts()) 
	        {
	            fileName = getFileName(part);
	           if(null != fileName){
	        	   part.write(savePath + File.separator + fileName);
	        	   x = fileName;
		            System.out.println(savePath + File.separator + fileName);
	           }
	           
	        }
	        fileName = x;
	        System.out.println(savePath + File.separator + fileName);
	        
	        Item item = new Item();
	        
	        String itemName = request.getParameter("itemName");
	    	String description =request.getParameter("description");
	    	double price =Double.parseDouble( request.getParameter("price"));
	    	String userID = request.getParameter("userID");
	    	String category = request.getParameter("category");
	    	
	    	String img_path = "./images/"+fileName;
	    	
	    	item.setItemName(itemName);
	    	item.setDescription(description);
	    	item.setPrice(price);
	    	item.setUserID(userID);
	    	item.setCategory(category);
	    	item.setImg_path(img_path);
	    	
	    	ItemHelper helper = new ItemHelper();
	    	try {
				helper.insertItem(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	forward(request, response, "/index.jsp");
	 		
}

	private String getFileName(Part file) 
	{
		String fileName = null;
		String contentDisposition = file.getHeader("Content-Disposition");
		if(contentDisposition != null) 
		{
			String[] tokens = contentDisposition.split(";");
			for(String token : tokens) 
			{
				token = token.trim();
				Matcher fileNameMatcher = FILE_NAME_PATTERN.matcher(token);
				if(fileNameMatcher.matches()) 
				{
				fileName = fileNameMatcher.group(1);
				}
			}
		}

	return fileName;
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException
	{
		ServletContext context = request.getServletContext();

		RequestDispatcher dispatcher = context.getRequestDispatcher(path);

		dispatcher.forward(request, response);
	}
}


