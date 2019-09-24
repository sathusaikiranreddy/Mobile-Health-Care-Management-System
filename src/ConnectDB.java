import java.sql.*;//importing sql 
import java.util.Scanner;
public class ConnectDB {
//database connection variables
	static Connection con = null;
	
	static String databaseName ="projectdatabase";
	
	static String url = "jdbc:mysql://localhost:3306/"+databaseName; //url with database name
	
	static String username = "root";//username of my db
	static String password ="Saikiran@1729";//password of my db plz dont tell to anyone :p
	
	public static Connection getconnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.jdbc.Driver").newInstance();//this will say to connect mysql
		
		con = DriverManager.getConnection(url,username,password);   //creating connection with database
		
		if(con!=null)
		{
			System.out.println("connected");
		}
		else {
			System.out.println("not connected");
		}
		return con;
	
		

		

	}
	
}
