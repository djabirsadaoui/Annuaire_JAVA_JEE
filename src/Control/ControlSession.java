package Control;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControlSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		out.println( "<html><body>" );
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if(name.equals(password))
			response.sendRedirect("index.html");
		else{
		
		out.println( "Hello  " + name + "   your password is "
		+ password + "</body></html>");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		if(name.equals(password)){
			String message ="hello ";
			request.setAttribute("test", message);
			RequestDispatcher rd = request.getRequestDispatcher( "/Accueil.jsp" );
			rd.forward(request, response);
			
			}
		else{
			out.println("mot de pass ou user error");
			response.sendRedirect("index.html");
		}
			
		
	
	}
}
