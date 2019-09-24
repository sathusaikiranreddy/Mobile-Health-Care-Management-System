import java.sql.*;
import java.time.*;
import java.text.*;
import java.util.*;
import java.util.Date;

public class Docter extends ConnectDB {

	public String name;

	
	
	
	public  String getName() {
		return name;
	}
	public  void setName(String name) {
		this.name = name;
	}

	
	public static String currentDate()
	{
		 DateFormat d = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		 Calendar calendar = Calendar.getInstance();
			String bdate = d.format(calendar.getTime());
			return bdate;
		
	}
	public static boolean available()
	{
		 DateFormat d = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		 int hours = calendar.get(Calendar.HOUR_OF_DAY);
		if(hours >= 8 & hours <=20 )
		{
			return true;
		}
		else {
			return false;
		}
	}

}
