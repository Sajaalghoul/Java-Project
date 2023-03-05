
public class Books {
	String Title;
	String Author;
	int year;
	
	public Books(String Title, String Author, int year) {
		this.Title=Title;
		this.Author=Author;
		this.year=year;
		
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString() {
		return("The Book of "+ this.Title+" By "+ this.Author);
	}

}
