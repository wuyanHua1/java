package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Book;
import DB.BookDBO;
import config.Config;

/**
 * Servlet implementation class DownloadTableServlet
 */
@WebServlet("/DownloadTableServlet")
public class DownloadTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		if(name!=null)
		{
			String filepath=Config.getInstance().getString("DownloadPath");
			String filename="table.csv";
			CreateFile(filename, filepath);
			OutPutTable(BookDBO.getInstance().Select(name), new File(filepath+"//"+filename));
			
			String file = filepath+"//"+filename;
			
			String contentType = this.getServletContext().getMimeType(file);
            String contentDisposition = "attachment;filename=table.csv";
            response.setHeader("Content-Type",contentType);
            response.setHeader("Content-Disposition",contentDisposition);
            
            FileInputStream input = new FileInputStream(file);
            ServletOutputStream output = response.getOutputStream();
            Copy(output, input);
            input.close();
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
	
	private boolean CreateFile(String filename,String filepath) throws IOException
	{
		File file1=new File(filepath);
		if(!file1.exists())
		{
			file1.mkdirs();
		}
		File file2=new File(filepath+"//"+filename);
		if(!file2.exists())
		{
			file1.createNewFile();
		}
		return true;
	}
	
	private void OutPutTable(List<Book> books,File file) throws IOException
	{
		try
		(
			FileOutputStream fileOutputStream=new FileOutputStream(file);
		)
		{
			String title="编号,书名,类别,出版商,状态\n";
			fileOutputStream.write(title.getBytes());
			for(Book book:books)
			{
				fileOutputStream.write(ToString(book).getBytes());
			}
		}
	}
	private String ToString(Book book)
	{
		String id=String.valueOf(book.getId());
		String string=id+","+book.getName()+","+book.getType()+","+book.getPublisher()+","+book.getState()+"\n";
		return string;
	}
	
	private void Copy(ServletOutputStream output,FileInputStream input) throws IOException
	{
		byte[] b=new byte[1024];
		while(input.read(b)>0)
		{
			output.write(b);
		}
	}
}
