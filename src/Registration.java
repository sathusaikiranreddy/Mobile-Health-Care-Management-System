import java.util.*;
import java.sql.*;
public class Registration {
	
//-------------------------------------------------------
	
public  Registration() {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("enter username");
	String username = sc.nextLine();
	System.out.println("enter password");
	String password= sc.nextLine();
	
	
	
	boolean passwordlimitation = passwordlength(password);
	if(passwordlimitation)
	{
		
		System.out.println("Strong password");
		System.out.println("enter your category");
		//String type = sc.nextLine();
		String type=category();
		System.out.println("enter u r age");
		int ag = sc.nextInt();
		sc.hasNextLine();
		String age ="";
		if(ag > 0 & ag <100)
		{
			age = Integer.toString(ag);
		}
		else
		{
			System.out.println("Invalid age");
			return;
		}
		sc.nextLine();
		System.out.println("enter u r phone number");
		String number = sc.nextLine();
		databaseRegister(username,password,type,age,number);
	
		
	}
	
	else
	{
		
		System.out.println("Weakpassword");
		
	}
	
}


//--------------------------------------------------------

public static boolean passwordlength(String password)
{
	
	int length=password.length();
	if(length >=7)
	{
		
		if(passwordvalidation(password))
		{
			
			return true;
			
		}
		else
			
			return false;
	}
	else {
		
		//System.out.println("password is too small");
		return false;
		
	}
}



//-------------------------------------------------------

public static boolean passwordvalidation(String password) {	 
	
	int length = password.length();
	boolean digit=false,uppercase=false,lowercase=false,scase=false;
	
	for(int i =0 ; i < length;i++)
	{
		
		char ch = password.charAt(i);
		
		if(Character.isDigit(ch) == true)
		{
			digit = true;
		}
		else if(Character.isUpperCase(ch))
		{
			uppercase = true;
		}
		else if(Character.isLowerCase(ch))
		{
			lowercase = true;
		}
		else
		{
			
			scase = true;
			
		}
		
		if(digit & uppercase & lowercase & scase)
			return true;
		
	} 
	
	return false;
	
	}


//-------------------------------------------------------------
public static String category()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("1->docter \n2->patient\n3->lab admin \n4->pharmacisits");
	int t = sc.nextInt();
	sc.nextLine();
	if(t==1)
	return "docter";
	else if(t==2)
		return "patient";
	else if(t==3)
		return "lab admin";
	else
		return "pharmacists";
	
	
}

public static void databaseRegister(String username, String password,String type,String age,String number)
{
	try {
	
	ConnectDB data = new ConnectDB();
	String query = "INSERT INTO user VALUES(?,?,?,?,?) ";
	PreparedStatement st = data.con.prepareStatement(query);
	st.setString(1, username);
	st.setString(2, password);
	st.setString(3, type);
	st.setString(4, age);
	st.setString(5, number);
	
	int status = st.executeUpdate();
	if(status >=1)
	{
		System.out.println("Registration successful");
		System.out.println("-------------------------");
	Login l = new Login();
		l.authentication();
	}
	else
		System.out.println("Registration unsuccessful");
		
	}
	catch(Exception e)
	{
		System.out.println("username is already exits select other username");
	}
	
}

}
