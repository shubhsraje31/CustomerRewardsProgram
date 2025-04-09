# CustomerRewardsProgram

/ * 
 * ## Customer Rewards Program
 * This Spring Boot Project calculates monthly and total customer reward points based on their transactions in the last 3 months.
 
 * ## Features
 * - REST endpoint to fetch reward points
 * - Points: 2 for every $ over 100, 1 for every $ over 50
 * - Unit and Integration tests
 * - Handles exceptions and edge cases
 * - JavaDocs included
  
 * ## Calculates reward points based on transaction amount:
    If amount > ₹100:
    Points = (amount - 100) * 2 + 50
    
    If amount > ₹50 and ≤ ₹100:
    Points = (amount - 50)
    
    If amount ≤ ₹50:
    No points
    
    👉 Example:
    
    ₹120 → (20 × 2) + 50 = 90 points
    
    ₹70 → 20 points

    ₹40 → 0 points
 */

## 📌 Overview
This Spring Boot application calculates customer reward points based on their transactions over the last 3 months.

### Reward Rules:
- **2 points** for every dollar spent over **$100**.
- **1 point** for every dollar spent between **$50 and $100**.

**Example:**
> $120 spent = 2×20 + 1×50 = **90 points**

The application provides REST APIs to view reward points **per customer, per month, and total**.

---

## 🏗️ Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.rewards
│   │       ├── controller         --> REST API Controller
│   │       ├── service            --> Business logic for rewards
│   │       ├── repository         --> JPA Repositories
│   │       ├── entity             --> Customer & Transaction models
│   │       └── exception          --> Global exception handling
│   └── resources
│       └── application.properties
│
├── test
│   └── java
│       └── com.example.rewards
│           └── service            --> Unit tests for RewardService
```

---

## 📡 API Endpoint

### `GET /api/rewards`
Returns a JSON map of customer reward points broken down by month and total.

**Sample Response:**
```json
{
    "Shubham": {
        "Total": 130,
        "MARCH": 90,
        "FEBRUARY": 40
    },
    "Sanket": {
        "Total": 250,
        "MARCH": 250,
        "JANUARY": 0
    },
    "Unnati": {
        "Total": 0,
        "APRIL": 0,
        "MARCH": 0
    },
    "Pooja": {
        "Total": 1750,
        "MARCH": 1060,
        "JANUARY": 690
    },
    "Anjali": {
        "Total": 1190,
        "MARCH": 1030,
        "FEBRUARY": 50,
        "JANUARY": 110
    }
}
```

---

## ✅ Features
- Dynamic month handling (not hard-coded)
- Unit and integration tests
- Exception and negative test scenarios
- JavaDoc documentation
- Formatted, standards-compliant code

---

## 🧪 Testing
- Test coverage includes:
  - Integration, Service Unit, and Repository Unit testing.
  - Custom exception handling

---


## 📘 JavaDocs
All service methods and classes are documented with JavaDocs for better clarity and maintainability.

---

## 📞 Contact
For queries or improvements, reach out to: **Shubham Barsagade**

---

Happy Coding! 🚀

