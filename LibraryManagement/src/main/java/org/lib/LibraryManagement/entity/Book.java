package org.lib.LibraryManagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String genre;
	
	@ManyToOne
	@JoinColumn(name="aurthor_id")
	private Aurthor aurthor;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL )
	@JsonIgnore
	private List<Loan> loans;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Aurthor getAurthor() {
		return aurthor;
	}
	public void setAurthor(Aurthor aurthor) {
		this.aurthor = aurthor;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	

}
