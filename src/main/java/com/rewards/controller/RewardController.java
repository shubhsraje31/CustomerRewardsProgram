package com.rewards.controller;

import com.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST controller for handling reward-related endpoints.
 *
 * Exposes APIs to:
 * - Get reward summary for all customers
 * * - Get reward summary for specific customer
 */
@RestController
@RequestMapping("/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping
    public Map<String, Map<String, Integer>> getRewards() {
        return rewardService.getCustomerMonthlyRewards();
    }

    @GetMapping("/{customerId}")
    public Map<String, Map<String, Integer>> getRewardsById(@PathVariable Long customerId) {
        return rewardService.getCustomerMonthlyRewardsById(customerId);
    }
}
