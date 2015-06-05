package entities;

public class User {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String rights;
	
	public User(String login, String password, String name, String surname, String rights) {
		this.setLogin(login);
		this.setPassword(password);
		this.setName(name);
		this.setSurname(surname);
		this.setRights(rights);
	}

	public User() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}
	
	
}
