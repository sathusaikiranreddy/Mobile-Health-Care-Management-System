
import java.util.*;

public class Main   {
	public static void main(String args[])
	{
		Docter sai = new Docter();
	//	sai.name = "saikiran";

		List<Docter> docterList = new ArrayList<Docter>();
		docterList.add(sai);
		Values v = new Values(docterList);
		v.print();
		//System.out.println(docterList);
	}

}
