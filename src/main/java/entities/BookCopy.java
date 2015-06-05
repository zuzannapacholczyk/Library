package entities;

public class BookCopy {
	private int id;
	private int bookId;
	private String issueNumber;
	private int departmentId;
	private String publisher;
	
	public BookCopy(int id, int bookId, String issueNumber, int departmentId, String publisher) {
		this.setId(id);
		this.setBookId(bookId);
		this.setIssueNumber(issueNumber);
		this.setDepartmentId(departmentId);
		this.setPublisher(publisher);
	}

	public BookCopy() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
}
