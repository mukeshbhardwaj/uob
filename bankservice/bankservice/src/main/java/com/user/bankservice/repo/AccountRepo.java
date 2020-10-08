package com.user.bankservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.bankservice.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

	Account findByAccountNumber(Long accountNumber);
}
