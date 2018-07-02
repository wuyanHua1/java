package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Manager;
import DB.LoginDBO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Id=request.getParameter("userID");
		String password=request.getParameter("password");
		if(Id!=null&&password!=null)
		{
			Manager user=new Manager();
			user.setPassword(password);
			user.setId(Integer.valueOf(Id));
			int i=LoginDBO.getInstance().find(user);
			if(i==1)
			{
				request.getRequestDispatcher("/WEB-INF/ManagerRoot.jsp").forward(request, response);
			}
			else if(i==2)
			{
				request.getRequestDispatcher("/WEB-INF/Manager.jsp").forward(request, response);
			}
			else
			{
				//System.out.println(password);
				response.sendRedirect("/JAVAandDB/page/default.html");
			}
		}
		else
		{
			//System.out.println(Id);
			response.sendRedirect("/JAVAandDB/page/default.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
