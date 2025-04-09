package com.rewards.repository;

import com.rewards.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Customer entities.
 * Extends JpaRepository to provide CRUD operations.
 *
 * JpaRepository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
