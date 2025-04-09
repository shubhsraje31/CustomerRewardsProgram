package com.rewards;

import com.rewards.entities.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.TransactionRepository;
import com.rewards.service.impl.RewardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RewardServiceImplTest {

    @InjectMocks
    private RewardServiceImpl rewardService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculatePoints() {
        assertEquals(90, rewardService.calculatePoints(BigDecimal.valueOf(120)));
        assertEquals(50, rewardService.calculatePoints(BigDecimal.valueOf(100)));
        assertEquals(0, rewardService.calculatePoints(BigDecimal.valueOf(40)));
    }


}
