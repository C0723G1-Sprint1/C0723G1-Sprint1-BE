package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Productions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductionsRepository extends JpaRepository<Productions,Integer> {

    /**
     * Author: AnHN.
     * This is the method to get the productions list and search by name
     * return ResponseEntity and product or null
     */
    @Query(value = "select * from productions",nativeQuery = true)
    List<Productions> findAllProductions();
}
