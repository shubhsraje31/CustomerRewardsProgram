package com.rewards;

import com.rewards.entities.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for {link TransactionRepository}.
 *
 * Tests the transaction repository methods.
 */
public class TransactionRepositoryTest {
    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

     @Test
     void testFindByTransactionDateBetween() {
         LocalDate startDate = LocalDate.now().minusDays(30);
         LocalDate endDate = LocalDate.now();
         List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(startDate, endDate);
         assertNotNull(transactions);
         assertTrue(transactions.isEmpty());
}

    @Test
    void testFindByTransactionDateBetweenByCustomerId() {
        long customerId = 1L; // Replace with a valid customer ID
        LocalDate startDate = LocalDate.now().minusDays(30);
        LocalDate endDate = LocalDate.now();
        List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId, startDate, endDate);
        assertNotNull(transactions);
        assertTrue(transactions.isEmpty());
    }

}
