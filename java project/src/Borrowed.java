
public class Borrowed extends Books {
	int id;
	public Borrowed(int id, String Title, String Author, int year) {
		super(Title,Author,year);
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
