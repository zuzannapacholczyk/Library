package entities;

public class FoundBook {

	private int id;
	private String issueNumber;
	private int departmentId;
	private String publisher;
	private boolean ifAvailable;
	private String authorName;
	private String authorSurname;
	private String title;

	public FoundBook(int id, String issueNumber, int departmentId,
			String publisher, boolean ifAvailable, String authorName,
			String authorSurname) {
		this.setId(id);
		this.setIssueNumber(issueNumber);
		this.setDepartmentId(departmentId);
		this.setPublisher(publisher);
		this.ifAvailable = ifAvailable;
		this.authorName = authorName;
		this.authorSurname = authorSurname;
	}

	public FoundBook() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean isIfAvailable() {
		return ifAvailable;
	}

	public void setIfAvailable(boolean ifAvailable) {
		this.ifAvailable = ifAvailable;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

	public void setTitle(String string) {
		this.title = string;
		
	}
	
	public String getTitle() {
		return title;
	}
}
