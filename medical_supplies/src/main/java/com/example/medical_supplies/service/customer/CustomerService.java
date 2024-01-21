package com.example.medical_supplies.service.customer;

import com.example.medical_supplies.model.auth.Customer;
import com.example.medical_supplies.repository.auth.IAccountRepository;
import com.example.medical_supplies.repository.customer.ICustomerRepository;
import com.example.medical_supplies.service.auth.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public void saveCustomer(Customer customer) {
        try {
            customerRepository.addCustomer(customer);

        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        Integer idAccount= accountRepository.findAccountByEmail(email);
        try {
            return customerRepository.findCustomerByAccountId(idAccount);
        }catch (Exception e){
            return null;
        }
    }
}
