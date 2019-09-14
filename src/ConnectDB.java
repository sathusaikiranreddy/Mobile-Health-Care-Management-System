import java.sql.*;//importing sql 
import java.util.Scanner;
public class ConnectDB {
//database connection variables
	static Connection con = null;
	
	static String databaseName ="projectdatabase";
	
	static String url = "jdbc:mysql://localhost:3306/"+databaseName; //url with database name
	
	static String username = "root";//username of my db
	static String password ="Saikiran@1729";//password of my db plz dont tell to anyone :p
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	/*	Scanner sc = new Scanner(System.in);
		int docterId = sc.nextInt();
		sc.nextLine();
		String docterName = sc.nextLine();*/
		Class.forName("com.mysql.jdbc.Driver").newInstance();//this will say to connect mysql
		
		con = DriverManager.getConnection(url,username,password);   //creating connection with database
		// TODO Auto-generated method stub
		if(con!=null)
		{
			System.out.println(" connected");
		}
		else {
			System.out.println("not connected");
		}
		con.close();
		
/*		PreparedStatement ps = con.prepareStatement("INSERT INTO docter(docterID,docterName) VALUES(?,?)");// this will create statement objects to insert values into tables
		
		int status =ps.executeUpdate();//executeUpdate will do all operations of DDL
		if(status!=0)
		{
			System.out.println("connected");
		}*/
		

	}
	
}
