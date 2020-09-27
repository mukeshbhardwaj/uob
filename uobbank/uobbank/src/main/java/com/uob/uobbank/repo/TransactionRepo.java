package com.uob.uobbank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.uob.uobbank.model.Transction;

public interface TransactionRepo extends JpaRepository<Transction, Long> {

	List<Transction> findByFromAccountOrToAccount(@Param("fromAccount") long fromAccount,
			@Param("toAccount") long toAccount);
}
