
public class Student extends User {
		String field;
	public Student(String field,String name, int id) {
		super(name,id);
		this.field=field;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	
}
