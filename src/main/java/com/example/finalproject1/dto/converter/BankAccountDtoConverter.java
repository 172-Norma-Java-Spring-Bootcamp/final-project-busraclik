package com.example.finalproject1.dto.converter;

import com.example.finalproject1.domain.BankAccount;
import com.example.finalproject1.dto.BankAccountDto;
import org.springframework.stereotype.Component;

@Component
public class BankAccountDtoConverter {
    public static BankAccountDto convert(BankAccount from){
        return new BankAccountDto(from.getIban(),from.getCurrentBalance());
    }
}
