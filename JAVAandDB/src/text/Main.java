package text;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;



public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
		try {
			System.out.println(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class c=Class.forName("DB.BookDBO");
		Field a=c.getDeclaredField("pool");
		a.setAccessible(true);
		System.out.println(a.getClass());
	}
	public void name() {
		File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
		System.out.println(this.getClass().getClassLoader().getResource("").getPath());//this.getClass().getClassLoader().getResource("").getPath();//
	}
	private static void CreateTable(String filename,String filepath) throws IOException
	{
		File file1=new File(filepath);
		if(!file1.exists())
		{
			file1.mkdirs();
			System.out.println("创建文件夹");
		}
		File file2=new File(filepath+"//"+filename);
		if(!file2.exists())
		{
			file1.createNewFile();
			System.out.println("创建文件");
		}
	}

}
