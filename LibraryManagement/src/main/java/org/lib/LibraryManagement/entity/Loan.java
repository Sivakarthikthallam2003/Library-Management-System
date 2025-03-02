package org.lib.LibraryManagement.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate loandate;
	private LocalDate retuendate;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn (name="memeber_id")
	private Member member;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getLoandate() {
		return loandate;
	}

	public void setLoandate(LocalDate loandate) {
		this.loandate = loandate;
	}

	public LocalDate getRetuendate() {
		return retuendate;
	}

	public void setRetuendate(LocalDate retuendate) {
		this.retuendate = retuendate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
