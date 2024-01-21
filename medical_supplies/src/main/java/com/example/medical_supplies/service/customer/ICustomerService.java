package com.example.medical_supplies.service.customer;

import com.example.medical_supplies.model.auth.Customer;

public interface ICustomerService {
    void saveCustomer(Customer customer);

    Customer findCustomerByEmail(String email);
}
