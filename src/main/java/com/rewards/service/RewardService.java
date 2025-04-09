package com.rewards.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public interface RewardService {
    Map<String, Map<String, Integer>> getCustomerMonthlyRewards();

    Map<String, Map<String, Integer>> getCustomerMonthlyRewardsById(long customerId);

    int calculatePoints(BigDecimal amount);

}
