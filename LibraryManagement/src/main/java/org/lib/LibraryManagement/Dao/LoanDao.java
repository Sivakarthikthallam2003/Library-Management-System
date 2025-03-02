package org.lib.LibraryManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.lib.LibraryManagement.entity.Loan;
import org.lib.LibraryManagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoanDao {
	@Autowired
	private LoanRepository loanRepository;
	
//	save aurthor
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}
	
// find all loan
	public List<Loan> getAll(){
		return loanRepository.findAll();
	}
	
// find by id
	public Optional<Loan> findByID(int id){
		return loanRepository.findById(id);
	}
//  update aurthor
	public Loan update(Loan loan) {
		return loanRepository.save(loan);
	}	
	
// Delete by id
	public void delete(Loan loan) {
		loanRepository.delete(loan);
		
	}

}
