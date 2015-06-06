package entities;

public class Book {
	private int id;
	private String title;
	
	public Book(String title) {
		this.setTitle(title);
	}
	
	public Book(int id, String title) {
		this.setId(id);
		this.setTitle(title);
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
