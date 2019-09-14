import java.sql.*;
public class ConnectDB {

	static Connection con = null;
	
	static String databaseName ="projectdatabase";
	
	static String url = "jdbc:mysql://localhost:3306/"+databaseName;
	
	static String username = "root";
	static String password ="Saikiran@1729";
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		con = DriverManager.getConnection(url,username,password);
		// TODO Auto-generated method stub
		
		PreparedStatement ps = con.prepareStatement("");
		
		int status =ps.executeUpdate();
		if(status !=0)
		{
			System.out.println("connected");
		}
		

	}

}
