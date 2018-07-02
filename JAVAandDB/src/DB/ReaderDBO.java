package DB;

import Util.ConnectionPool;

public class ReaderDBO {
	private ReaderDBO() {}
	private static ReaderDBO Instance=new ReaderDBO();
	public static ReaderDBO getInstance() {
		return Instance;
	}
	
	private ConnectionPool pool=ConnectionPool.getInstance();
	
}
