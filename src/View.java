import java.sql.*;;

public class View {
	public void display() throws SQLException
	{
		try {
			//Docter doc = new Docter();
		ConnectDB d = new ConnectDB();
		String str = "SELECT * FROM user";
		Statement st = d.con.createStatement();
		ResultSet rs = st.executeQuery(str);
		System.out.println("NMAE      CATEGORY      AGE        PHONENUMBER");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"  "+rs.getString(3)+"        "+rs.getString(4)+"         "+rs.getString(5));
			//System.out.println("Time is "+doc.currentDate());
		}
	}
		catch(Exception e)
		{
			System.out.println("exception has occured");
		}
		
	}

}
