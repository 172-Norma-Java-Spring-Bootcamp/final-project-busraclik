package com.example.finalproject1.controller;

import com.example.finalproject1.domain.Customer;
import com.example.finalproject1.dto.CreateCustomerRequest;
import com.example.finalproject1.dto.CustomerDto;
import com.example.finalproject1.dto.UpdateCustomerRequest;
import com.example.finalproject1.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

        @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        try {
            List<CustomerDto> list = customerService.getAllCustomerList();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
      return ResponseEntity.ok(customerService.getCustomerById(id));
    }


        @PostMapping("/customers")
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody Customer createCustomerRequest) {
        try {
            return new ResponseEntity<>(customerService.saveCustomer(createCustomerRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id ,@RequestBody Customer customer) {
        try {
            return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }











//before service layer


    //    private final ICustomerRepository customerRepository;
//
//    public CustomerController(ICustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }



//    @GetMapping("/customers")
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        try {
//            List<Customer> list = customerRepository.findAll();
//
//            if (list.isEmpty() || list.size() == 0) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//    @GetMapping("/customers/{id}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
//        Optional<Customer> customer = customerRepository.findById(id);
//
//        if (customer.isPresent()) {
//            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @PostMapping("/customers")
//    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
//        try {
//            return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/customers")
//    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
//        try {
//            return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @DeleteMapping("/customers/{id}")
//    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
//        try {
//            Optional<Customer> customer = customerRepository.findById(id);
//            if (customer.isPresent()) {
//                customerRepository.delete(customer.get());
//            }
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



}
