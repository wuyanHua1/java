package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Book;
import DB.BookDBO;

/**
 * Servlet implementation class BookFindByID
 */
@WebServlet("/BookFindByID")
public class BookFindByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFindByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		
		String idStr=request.getParameter("id");
		if(idStr!=null)
		{
			Book book=BookDBO.getInstance().Find(Integer.valueOf(idStr));
			if(book!=null)
			{
				String re=book.getName()+";"+book.getPublisher()+";"+book.getType();
				response.getWriter().write(re);
			}
			else {
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
