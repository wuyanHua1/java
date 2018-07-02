package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Book;
import DB.BookDBO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//response.setCharacterEncoding("UTF-8");
		BookDBO dbo=BookDBO.getInstance();
		String name=request.getParameter("name");
		if(name!=null)
		{
			List<Book> books=dbo.Select(name);
			String HTML=CodeHTML(books);
			response.getWriter().write(HTML);
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
	private String Codetable(int id,String BookName,String type,String publisher,String state)
	{
		 String string="<tr class=\"odd gradeX\">\r\n" + 
						"<td>"+id+"</td>\r\n" + 
						"<td>"+BookName+"</td>\r\n" + 
						"<td>"+type+"</td>\r\n" + 
						"<td class=\"center\">"+publisher+"</td>\r\n" + 
						"<td class=\"center\">"+state+"</td>\r\n" + 
						"</tr>\r\n";
		 return string;
	}
	private String CodeHTML(List<Book> books)
	{
		String HTML="";
		for(Book book:books)
		{
			HTML+=Codetable(book.getId(),book.getName(), book.getType(), book.getPublisher(), book.getState());
		}
		if(books.isEmpty())
		{
			HTML="无查询结果";
		}
		return HTML;
	}
}
