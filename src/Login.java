import java.sql.*;
import java.util.Scanner;

public class Login {
	public static void log()
	{
		try{
		
		ConnectDB data = new ConnectDB();
		
		String query = "SELECT * FROM user WHERE name=? and password =?";
		PreparedStatement st = ConnectDB.getconnection().prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		System.out.println("Login \nuserName");
		String name = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		
		st.setString(1,name);
		st.setString(2,password);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next())
		{
			System.out.println("login successful");
		}
		
		else {
			
			System.out.println("unsuccessful login");
			System.out.println("enter \"1\" for new registration or \"0\" for cancel");
			int newu = sc.nextInt();
			if(newu == 1)
			{
				System.out.println("Registration form");
				Registration r = new Registration();
			}
			else
			{
				System.out.println("cancel");
				return ;
			}
		}
		
		}
		catch(Exception e)
		{
		
		}
			
	}
	public static void main(String  args[] )
	{
		Login l = new Login();
		l.log();
	}

}
