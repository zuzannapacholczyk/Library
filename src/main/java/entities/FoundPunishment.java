package entities;

import java.util.ArrayList;
import java.util.List;

public class FoundPunishment {
	private int id;
	private int borrowingId;
	private String title;
	private String name;
	private String surname;
	private Float amount;
	private String borrowingDate;
	private String punishmentDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getBorrowingDate() {
		return borrowingDate;
	}
	public void setBorrowingDate(String borrowingDate) {
		this.borrowingDate = borrowingDate;
	}
	public String getPunishmentDate() {
		return punishmentDate;
	}
	public void setPunishmentDate(String punishmentDate) {
		this.punishmentDate = punishmentDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBorrowingId() {
		return borrowingId;
	}
	public void setBorrowingId(int borrowingId) {
		this.borrowingId = borrowingId;
	}
	
	public List<String> changeIntoList() {
		List<String> elems = new ArrayList<String>();
		elems.add(getTitle());
		elems.add(getName());
		elems.add(getSurname());
		elems.add(String.valueOf(getAmount()));
		elems.add(String.valueOf(getBorrowingDate()));
		elems.add(String.valueOf(getPunishmentDate()));
		return elems;
	}
}
