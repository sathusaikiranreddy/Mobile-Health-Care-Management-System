import java.sql.*;
import java.util.Scanner;

public class Update {
	
	public Update() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 1 to update username or enter  2 to remove user ");
		int dis = sc.nextInt();
		if(dis == 1)
		{
			update();
		}
		else if(dis == 2)
		{
			delete();
		}
		
	}
	
	public void update() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		ConnectDB d = new ConnectDB();
		//System.out.println("patient has been discharge");
		String oldname = sc.nextLine();
		String newname = sc.nextLine();	
		View v = new View();
		v.display();
		String str = "UPDATE user SET name=? WHERE name =?";
		PreparedStatement ps = d.con.prepareStatement(str);
		ps.setString(1, newname);
		ps.setString(1, oldname);
		int status = ps.executeUpdate();
		
		
		v.display();
		
		
	}
	
//--------------------------------------------
	
	
	
	
	
	public void delete() throws SQLException
	{
		ConnectDB d = new ConnectDB();
		Scanner sc = new Scanner(System.in);
		String colname = sc.nextLine();
		String str ="DELETE FROM user WHERE name=?";
		PreparedStatement ps = d.con.prepareStatement(str);
		ps.setString(1,colname);
		int status = ps.executeUpdate();
		if(status >= 1)
		{
			System.out.println("remove sucessfully");
		}
		else
		{
			System.out.println("not removed sucessfully");
		}
		
	}
	
	
	

}
