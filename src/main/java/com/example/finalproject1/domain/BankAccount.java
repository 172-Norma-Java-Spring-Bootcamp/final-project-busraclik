package com.example.finalproject1.domain;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
public class BankAccount extends BaseDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String iban;
    private BigDecimal currentBalance;

    @OneToOne(mappedBy = "bankAccount")
    private Customer customer;

    @OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "bankAccount", fetch = FetchType.LAZY)
    private Card card;


}
