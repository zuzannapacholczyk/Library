package entities;

public class Author {
	private int id;
	private String name;
	private String surname;
	
	public Author(int id, String name, String surname) {
		this.setId(id);
		this.setSurname(surname);
		this.setName(name);
	}
	
	public Author(String name, String surname) {
		this.setSurname(surname);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
