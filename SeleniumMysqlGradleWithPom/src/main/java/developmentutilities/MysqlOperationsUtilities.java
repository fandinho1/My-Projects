package developmentutilities;

public class MysqlOperationsUtilities {
	private static String JDBC = "jdbc:mysql://localhost:3306/datos?autoReconnect=true&useSSL=false";
	private static String USER = "root";
	private static String PASSWORD = "1234";
	
	public static String getJDBC() {
		return JDBC;
	}
	public static String getUSER() {
		return USER;
	}
	public static String getPASSWORD() {
		return PASSWORD;
	}

}
