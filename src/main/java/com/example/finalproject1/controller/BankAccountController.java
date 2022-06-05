package com.example.finalproject1.controller;

import com.example.finalproject1.domain.BankAccount;
import com.example.finalproject1.dto.BankAccountDto;
import com.example.finalproject1.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/bank")
public class BankAccountController {


    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<BankAccountDto>> getAllBankAccounts() {
        try {
            List<BankAccountDto> list = bankAccountService.getAllBankAccountList();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/accounts/{id}")
    public ResponseEntity<BankAccountDto> getBankAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(bankAccountService.getBankAccountById(id));
    }


    @PostMapping("/accounts")
    public ResponseEntity<BankAccountDto> saveBankAccount(@RequestBody BankAccount createBankAccountRequest) {
        try {
            return new ResponseEntity<>(bankAccountService.saveBankAccount(createBankAccountRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<BankAccountDto> updateBankAccount(@PathVariable("id") Long id ,@RequestBody BankAccount bankAccount) {
        try {
            return new ResponseEntity<>(bankAccountService.updateCBankAccount(id, bankAccount), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable("id") Long id) {
        bankAccountService.deleteBankAccount(id);
        return ResponseEntity.ok().build();
    }










    //before service layer
//    private final IBankAccountRepository bankAccountRepository;
//
//    public BankAccountController(IBankAccountRepository bankAccountRepository) {
//        this.bankAccountRepository = bankAccountRepository;
//    }
//
//    @GetMapping("/account")
//    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
//        try {
//            List<BankAccount> list = bankAccountRepository.findAll();
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
//
//
//    @GetMapping("/accounts/{id}")
//    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long id) {
//        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
//
//        if (bankAccount.isPresent()) {
//            return new ResponseEntity<>(bankAccount.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping("/accounts")
//    public ResponseEntity<BankAccount> saveBankAccount(@RequestBody BankAccount bankAccount) {
//        try {
//            return new ResponseEntity<>(bankAccountRepository.save(bankAccount), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//
//    @PutMapping("/accounts")
//    public ResponseEntity<BankAccount> updateBankAccount(@RequestBody BankAccount bankAccount) {
//        try {
//            return new ResponseEntity<>(bankAccountRepository.save(bankAccount), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @DeleteMapping("/accounts/{id}")
//    public ResponseEntity<HttpStatus> deleteBankAccountById(@PathVariable Long id) {
//        try {
//            Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
//            if (bankAccount.isPresent()) {
//                bankAccountRepository.delete(bankAccount.get());
//            }
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//







}
