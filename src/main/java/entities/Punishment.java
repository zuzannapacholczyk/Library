package entities;

import java.sql.Date;

public class Punishment {
	private int borrowingId;
	private float amount;
	private Date beginningDate;
	private Date endDate;
	
	public Punishment(int borrowingId, float amount, Date beginningDate, Date endDate) {
		this.setBorrowingId(borrowingId);
		this.setAmount(amount);
		this.setBeginningDate(beginningDate);
		this.setEndDate(endDate);
	}

	public int getBorrowingId() {
		return borrowingId;
	}

	public void setBorrowingId(int borrowingId) {
		this.borrowingId = borrowingId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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
