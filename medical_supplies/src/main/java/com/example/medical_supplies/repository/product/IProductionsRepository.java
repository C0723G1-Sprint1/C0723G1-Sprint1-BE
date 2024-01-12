package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Productions;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface IProductionsRepository extends JpaRepository<Productions,Integer> {



}
