package entities;

public class Reader {
	private int id;
	private String name;
	private String surname;
	private String address;
	private String email;
	
	public Reader(int id, String name, String surname, String address, String email) {
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setAddress(address);
		this.setEmail(email);
	}
	
	public Reader(String name, String surname, String address, String email) {
		this.setName(name);
		this.setSurname(surname);
		this.setAddress(address);
		this.setEmail(email);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
