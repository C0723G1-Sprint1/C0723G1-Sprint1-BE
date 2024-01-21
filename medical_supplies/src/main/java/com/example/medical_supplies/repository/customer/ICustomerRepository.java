package com.example.medical_supplies.repository.customer;

import com.example.medical_supplies.model.auth.Customer;
import com.example.medical_supplies.model.auth.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into customers (`code`,`name`,birthday,phone,address,id_account) " +
            "values (:#{#customer.code},:#{#customer.name},:#{#customer.birthday}, :#{#customer.phone},:#{#customer.address}," +
            ":#{#customer.account.id})",nativeQuery = true)
    void addCustomer(@Param("customer") Customer customer);

    @Query(value = "select * from customers where id_account = :id",nativeQuery = true)
    Customer findCustomerByAccountId(@Param("id") Integer id);
}
