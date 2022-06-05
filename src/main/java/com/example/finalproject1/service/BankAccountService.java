package com.example.finalproject1.service;

import com.example.finalproject1.domain.BankAccount;
import com.example.finalproject1.dto.BankAccountDto;
import com.example.finalproject1.dto.converter.BankAccountDtoConverter;
import com.example.finalproject1.repository.IBankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountService {
    private IBankAccountRepository bankAccountRepository;
    private final BankAccountDtoConverter bankAccountDtoConverter;

    public BankAccountService(IBankAccountRepository bankAccountRepository, BankAccountDtoConverter bankAccountDtoConverter) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountDtoConverter = bankAccountDtoConverter;
    }


    public List<BankAccountDto> getAllBankAccountList() {

        return bankAccountRepository.findAll().stream().map(from -> BankAccountDtoConverter.convert(from)).collect(Collectors.toList());
    }


    public BankAccountDto getBankAccountById(Long bankAccountId) {
        BankAccount bankAccount = bankAccountRepository.findById(bankAccountId).get();
        return BankAccountDtoConverter.convert(bankAccount);
    }

    public BankAccountDto saveBankAccount(BankAccount bankAccount) {
//
//        Customer customer = new Customer(customerRequest.getFirstName(),
//                          customerRequest.getLastName(),
//                          customerRequest.getEmail());
//
//        return customerDtoConverter.convert(customerRepository.save(customer));

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        //log.info("Customer saved by id: {}", savedCustomer.getId());

        return bankAccountDtoConverter.convert(bankAccountRepository.save(savedBankAccount));

        // return savedCustomer;
    }

    public BankAccountDto updateCBankAccount(Long id, BankAccount bankAccount){
        BankAccount updatedBankAccount = findBankAccountById(id);
        updatedBankAccount.setIban(bankAccount.getIban());
        updatedBankAccount.setCurrentBalance(bankAccount.getCurrentBalance());
        return bankAccountDtoConverter.convert(bankAccountRepository.save(updatedBankAccount));
    }

    public void deleteBankAccount(Long id){
        BankAccount bankAccount = findBankAccountById(id);
        bankAccountRepository.delete(bankAccount);
    }


    //dont repeat yourself
    private BankAccount findBankAccountById(Long id){
        return bankAccountRepository.findById(id).get();
    }
}
