package com.example.finalproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {
    private String iban;
    private BigDecimal currentBalance;
}
