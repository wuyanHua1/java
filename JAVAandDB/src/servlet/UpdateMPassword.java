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
 * Servlet implementation class UpdateMPassword
 */
@WebServlet("/UpdateMPassword")
public class UpdateMPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString=request.getParameter("id");
		String olderPassword=request.getParameter("OlderPassword");
		String newPassword=request.getParameter("NewPassword");
		if(idString!=null&&olderPassword!=null&&newPassword!=null)
		{
			Manager manager=new Manager();
			manager.setId(Integer.valueOf(idString));
			manager.setPassword(olderPassword);
			if(LoginDBO.getInstance().UpdateManager(manager, newPassword))
			{
				response.getWriter().write("TRUE");
			}
			else
			{
				response.getWriter().write("FALSE");
			}
		}
		else
		{
			response.setStatus(404);
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
