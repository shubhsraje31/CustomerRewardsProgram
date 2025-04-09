package com.rewards;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integration test class.
 *
 * Tests the responses from the REST endpoints.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RewardControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetRewards() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/rewards", Map.class);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetRewardsById() {
        long customerId = 1L; // Replace with a valid customer ID in your database
        ResponseEntity<Map> response = restTemplate.getForEntity("/rewards/" + customerId, Map.class);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
}