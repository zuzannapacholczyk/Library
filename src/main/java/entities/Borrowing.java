package entities;

import java.sql.Date;

public class Borrowing {
	private int id;
	private int copyId;
	private int readerId;
	private Date beginningDate;
	private Date endDate;
	
	public Borrowing(int id, int copyId, int readerId, Date beginningDate, Date endDate){
		this.setId(id);
		this.setCopyId(copyId);
		this.setReaderId(readerId);
		this.setBeginningDate(beginningDate);
		this.setEndDate(endDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public Date getBeginningDate() {
		return beginningDate;
	}

	public void setBeginningDate(Date beginningDate) {
		this.beginningDate = beginningDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
