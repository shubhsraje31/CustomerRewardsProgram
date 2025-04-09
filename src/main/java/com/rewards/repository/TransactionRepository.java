package com.rewards.repository;

import com.rewards.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for managing Transaction entities.
 * Extends JpaRepository to provide CRUD operations.
 *
 *  JpaRepository
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTransactionDateBetween(LocalDate start, LocalDate end);
    List<Transaction> findByCustomerIdAndTransactionDateBetween(long customerId, LocalDate start, LocalDate end);
}
