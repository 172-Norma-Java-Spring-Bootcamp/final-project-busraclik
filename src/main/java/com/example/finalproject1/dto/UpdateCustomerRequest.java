package com.example.finalproject1.dto;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    //customer update islemei icin kullanılacak
    private String firstName;
    private String lastName;
    private String email;
}
