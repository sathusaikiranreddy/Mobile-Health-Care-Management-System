
import java.sql.*;
import java.util.Scanner;

public class Patient {
	static String docterName="";
	 static int num=0;
	 
	public static void appointment()
	{
		try {
			ConnectDB  d = new ConnectDB();
			String str3 = "DELETE FROM docter";
			PreparedStatement p = d.con.prepareStatement(str3);
			p.executeUpdate();
			//appointment();
			//System.out.println("cannot book app"+e);
			}
			catch(Exception ex)
			{
				System.out.println("caught");
			}
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("number of docter available are");
		ConnectDB d = new ConnectDB();
		String str = "SELECT name FROM user WHERE type='docter'";
		Statement st = d.con.createStatement();
		ResultSet rs = st.executeQuery(str);
		while(rs.next())
		{
			num++;
			System.out.println(num+" "+rs.getString(1));
			docterName=rs.getString(1);
			String str2 = "INSERT INTO docter(doctername) VALUES(?)";
			PreparedStatement p = d.con.prepareStatement(str2);
			p.setString(1, docterName);
			p.executeUpdate();
			
			
		}
		System.out.println("enter docter name to book appointment and patient name");
		String name = sc.nextLine();
		String pa = sc.nextLine();
		String str2 = "UPDATE docter SET appointment=1,patientname="+pa+" WHERE doctername="+name;
		PreparedStatement p = d.con.prepareStatement(str2);
	//	p.setString(1, name);
		
		int status = p.executeUpdate();
		if(status >=1)
		{
			System.out.println("appiontment has been booked");
			
		}
		else
			System.out.println("canceled");
		
		}
		catch(Exception e)
		{
			
			
			System.out.println("cannot book app"+e);
			
			
			
		}
		
		
	}

}
