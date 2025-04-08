package com.rewards.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amount;
    private LocalDate transactionDate;

    private long customerId;

    public Transaction(Long id, BigDecimal bigDecimal, LocalDate localDate) {
        this.customerId = id;
        this.amount = bigDecimal;
        this.transactionDate = localDate;

    }
}
