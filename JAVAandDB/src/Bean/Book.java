package Bean;

public class Book {
	private int id;
	private String name;
	private String type;
	private String publisher;
	private String state;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getState() {
		return state;
	}
	public String getType() {
		return type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setType(String type) {
		this.type = type;
	}
}
