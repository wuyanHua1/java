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
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/BookUpdateServlet")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String idString=request.getParameter("id");
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String publisher=request.getParameter("publisher");
		if(name!=null&&idString!=null&&type!=null&&publisher!=null)
		{
			Book book=new Book();
			book.setId(Integer.valueOf(idString));
			book.setName(name);
			book.setPublisher(publisher);
			book.setType(type);
			if(BookDBO.getInstance().UpdateBook(book))
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
