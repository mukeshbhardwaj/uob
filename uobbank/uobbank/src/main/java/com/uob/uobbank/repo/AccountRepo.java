package com.uob.uobbank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uob.uobbank.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

	Account findByAccountNumber(Long accountNumber);
}
