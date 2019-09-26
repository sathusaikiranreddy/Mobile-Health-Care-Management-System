import java.sql.*;
import java.util.Scanner;


//---------------------------------------------------------------------

public class Login {
	public static void log()
	{
		try{
		
		ConnectDB data = new ConnectDB();
		data.getconnection();
		authentication();
		data.con.close();
		
		}
		catch(Exception e)
		{
		
		}
	}
	
	
	
//----------------------------------------------------------------------	
	
	public static void authentication() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println("        Login        \nuserName");
		String name = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		String query = "SELECT * FROM user WHERE name=? and password =?";
		ConnectDB d = new ConnectDB();
		PreparedStatement st = d.con.prepareStatement(query);
		st.setString(1,name);
		st.setString(2,password);
		
		ResultSet rs = st.executeQuery();
//-----------------------------------
		
		
		if(rs.next())
		{
			System.out.println("login successful");
			System.out.println("-----------------------");
			System.out.println("Welcome "+name);
			System.out.println("-----------------------\n enter 1 to view hospital data or enter  2 to update or enter 3  for docter availability");
			int c = sc.nextInt();
			if(c == 1)
			{
			View v = new View();
			v.display();
			}
			else if(c==2)
			{
				System.out.println("---------------------");
				Update u = new Update();
				
			//	View v = new View();
			//	v.display();	
			}
			else if(c == 3)
			{
				Docter doc = new Docter();
			}
		}
//-----------------------------------------------------
		
		
		else {
			
			System.out.println("unsuccessful login");
			System.out.println("------------------------");
			System.out.println("enter \"0\" for cancel or \"1\" for registration or \"2\" to login ");
			int newu = sc.nextInt();
			if(newu == 1)
			{
				System.out.println("Registration form");
				Registration r = new Registration();
			}
			else if(newu == 0)
			{
				System.out.println("cancel");
				return ;
			}
			else if(newu ==2)
			{
				Login l = new Login();
				l.log();
			}
		}
		
	}

	
//-------------------------------------------------------------------
	public static void main(String  args[] )
	{
		Login l = new Login();
		l.log();
	}

}
