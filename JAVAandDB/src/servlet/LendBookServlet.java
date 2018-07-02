package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.BookDBO;
import DB.LendDBO;

/**
 * Servlet implementation class LendBookServlet
 */
@WebServlet("/LendBookServlet")
public class LendBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		
		String bookId=request.getParameter("bookId");
		String readerId=request.getParameter("readerId");
		if(readerId!=null&&bookId!=null)
		{
			String state="½è³öÊ±¼ä£º"+new Date(System.currentTimeMillis()).toString();
			boolean lend=LendDBO.getInstance().InsertLend(Integer.valueOf(bookId), Integer.valueOf(readerId));
			boolean book=BookDBO.getInstance().UpdateBookStatue(Integer.valueOf(bookId),state);
			if(book&&lend)
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
