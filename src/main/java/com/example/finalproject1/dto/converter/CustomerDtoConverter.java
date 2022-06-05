package com.example.finalproject1.dto.converter;

import com.example.finalproject1.domain.Customer;
import com.example.finalproject1.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public CustomerDto convert(Customer from){
        return new CustomerDto(from.getFirstName(),from.getLastName());
    }
}
