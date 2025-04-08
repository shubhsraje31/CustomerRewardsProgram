package com.rewards.config;


import com.rewards.entities.Customer;
import com.rewards.entities.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public DataLoader(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) {
        Customer c1 = customerRepository.save(new Customer("Shubham"));
        Customer c2 = customerRepository.save(new Customer("Sanket"));
        Customer c3 = customerRepository.save(new Customer("Unnati"));
        Customer c4 = customerRepository.save(new Customer("Pooja"));
        Customer c5 = customerRepository.save(new Customer("Anjali"));

        transactionRepository.saveAll(Arrays.asList(
                new Transaction(c1.getId(), BigDecimal.valueOf(120), LocalDate.now().minusDays(10)),
                new Transaction(c1.getId(), BigDecimal.valueOf(90), LocalDate.now().minusDays(40)),
                new Transaction(c2.getId(), BigDecimal.valueOf(200), LocalDate.now().minusDays(20)),
                new Transaction(c2.getId(), BigDecimal.valueOf(30), LocalDate.now().minusDays(70)),
                new Transaction(c3.getId(), BigDecimal.valueOf(10), LocalDate.now().minusDays(5)),
                new Transaction(c3.getId(), BigDecimal.valueOf(190), LocalDate.now().minusDays(30)),
                new Transaction(c4.getId(), BigDecimal.valueOf(300), LocalDate.now().minusDays(20)),
                new Transaction(c4.getId(), BigDecimal.valueOf(380), LocalDate.now().minusDays(35)),
                new Transaction(c4.getId(), BigDecimal.valueOf(420), LocalDate.now().minusDays(75)),
                new Transaction(c5.getId(), BigDecimal.valueOf(590), LocalDate.now().minusDays(15)),
                new Transaction(c5.getId(), BigDecimal.valueOf(100), LocalDate.now().minusDays(40)),
                new Transaction(c5.getId(), BigDecimal.valueOf(130), LocalDate.now().minusDays(68))
        ));
    }
}
