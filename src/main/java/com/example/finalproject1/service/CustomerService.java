package com.example.finalproject1.service;

import com.example.finalproject1.domain.Customer;
import com.example.finalproject1.dto.CustomerDto;
import com.example.finalproject1.dto.converter.CustomerDtoConverter;
import com.example.finalproject1.repository.ICustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {

    private ICustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(ICustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;

        this.customerDtoConverter = customerDtoConverter;
    }


    public List<CustomerDto> getAllCustomerList() {

        return customerRepository.findAll().stream().map(customerDtoConverter::convert).collect(Collectors.toList());
    }


    public CustomerDto getCustomerById(Long customerId) {

        Customer customer = customerRepository.findById(customerId).get();
        return customerDtoConverter.convert(customer);

    }

    public CustomerDto saveCustomer(Customer customer) {
//
//        Customer customer = new Customer(customerRequest.getFirstName(),
//                          customerRequest.getLastName(),
//                          customerRequest.getEmail());
//
//        return customerDtoConverter.convert(customerRepository.save(customer));

        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer saved by id: {}", savedCustomer.getId());

        return customerDtoConverter.convert(customerRepository.save(savedCustomer));

       // return savedCustomer;
    }

    public CustomerDto updateCustomer(Long id, Customer customer){
        Customer updatedCustomer = findCustomerById(id);
        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setEmail(customer.getEmail());
        return customerDtoConverter.convert(customerRepository.save(updatedCustomer));
    }

    public void deleteCustomer(Long id){
        Customer customer = findCustomerById(id);
        customerRepository.delete(customer);
    }


    //dont repeat yourself
    private Customer findCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

}
