package com.rewards.service.impl;

import com.rewards.entities.Customer;
import com.rewards.entities.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.TransactionRepository;
import com.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
RewardService class Implementation.
 */
@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Map<String, Map<String, Integer>> getCustomerMonthlyRewards() {
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
        List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(threeMonthsAgo, LocalDate.now());

        Map<Long, String> customerMap = customerRepository.findAll().stream()
                .collect(Collectors.toMap(Customer::getId, Customer::getName));

        if (customerMap.isEmpty()) {
            throw new RuntimeException("No customers found in the database.");
        }
        if (transactions.isEmpty()) {
            throw new RuntimeException("No transactions found in the database.");
        }

        Map<String, Map<String, Integer>> result = new LinkedHashMap<>();

        for (Transaction t : transactions) {
            String name = customerMap.get(t.getCustomerId());
            if (name == null) continue;
            int points = calculatePoints(t.getAmount());
            String month = t.getTransactionDate().getMonth().toString();

            result.computeIfAbsent(name, k -> new LinkedHashMap<>());
            result.get(name).merge("Total", points, Integer::sum);
            result.get(name).merge(month, points, Integer::sum);


        }

        return result;
    }

    @Override
    public Map<String, Map<String, Integer>> getCustomerMonthlyRewardsById(long customerId) {
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
        /*List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(threeMonthsAgo, LocalDate.now())
                .stream()
                .filter(t -> t.getCustomerId() == customerId)
                .collect(Collectors.toList());*/

        List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId, threeMonthsAgo, LocalDate.now());

        Map<Long, String> customerMap = customerRepository.findById(customerId).stream()
                .collect(Collectors.toMap(Customer::getId, Customer::getName));

        if (customerMap.isEmpty()) {
            throw new RuntimeException("No customer found in the database with the CustomerId: " + customerId);
        }
        if (transactions.isEmpty()) {
            throw new RuntimeException("No transactions found in the database for the CustomerId: " + customerId);
        }

        Map<String, Map<String, Integer>> result = new LinkedHashMap<>();

        for (Transaction t : transactions) {
            String name = customerMap.get(t.getCustomerId());
            if (name == null) continue;
            int points = calculatePoints(t.getAmount());
            String month = t.getTransactionDate().getMonth().toString();

            result.computeIfAbsent(name, k -> new LinkedHashMap<>());
            result.get(name).merge("Total", points, Integer::sum);
            result.get(name).merge(month, points, Integer::sum);


        }

        return result;
    }

    @Override
    public int calculatePoints(BigDecimal amount) {
        int points = 0;
        if (amount.compareTo(BigDecimal.valueOf(100)) > 0) {
            points += (amount.intValue() - 100) * 2 + 50;
        } else if (amount.compareTo(BigDecimal.valueOf(50)) > 0) {
            points += (amount.intValue() - 50);
        }
        return points;
    }
}
