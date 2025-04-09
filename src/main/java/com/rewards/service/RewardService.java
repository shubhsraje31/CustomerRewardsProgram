package com.rewards.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class responsible for calculating reward points
 * based on customer transactions.
 *
 * Provides logic to:
 * - Fetch transactions in the last 3 months
 * - Group them by customer and month
 * - Calculate points using business rules
 */

@Service
public interface RewardService {
    Map<String, Map<String, Integer>> getCustomerMonthlyRewards();

    Map<String, Map<String, Integer>> getCustomerMonthlyRewardsById(long customerId);

    int calculatePoints(BigDecimal amount);

}
