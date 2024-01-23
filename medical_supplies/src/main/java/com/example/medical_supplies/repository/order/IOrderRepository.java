package com.example.medical_supplies.repository.order;

import com.example.medical_supplies.model.auth.Customer;
import com.example.medical_supplies.model.cart.Orders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<Orders, Integer> {
   
}
