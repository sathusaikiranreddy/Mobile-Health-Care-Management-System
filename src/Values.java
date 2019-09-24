import java.util.List;

public class Values {

	private List<Docter> docters;

	public Values(List<Docter> docter) {
		super();
		this.docters = docter;
	}

	public List<Docter> getDocter() {
		return docters;
	}

	public void setDocter(Docter docter) {
		docters.add(docter);
	}
	public void print()
	{
		System.out.println(getDocter());
	}


}
