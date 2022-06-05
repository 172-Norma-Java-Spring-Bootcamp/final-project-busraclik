package com.example.finalproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {
    //customer create islemi icin kullanılacak
    private String firstName;
    private String lastName;
    private String email;

}
