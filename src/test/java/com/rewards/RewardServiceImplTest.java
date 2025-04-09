package com.rewards;

import com.rewards.service.impl.RewardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test class for {link RewardService}.
 *
 * Tests the reward points calculation logic.
 */
class RewardServiceImplTest {

    @InjectMocks
    private RewardServiceImpl rewardService;

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
