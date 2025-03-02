package org.lib.LibraryManagement.repository;

import org.lib.LibraryManagement.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
