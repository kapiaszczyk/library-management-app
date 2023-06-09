package dev.kapiaszczyk.bookstore.library.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByAccountNumber(String accountNumber);

    List<Loan> findByAccountNumberAndStatus(String accountNumber, Loan.Status status);

}
