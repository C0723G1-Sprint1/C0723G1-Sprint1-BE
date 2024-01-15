package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Productions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductionsRepository extends JpaRepository<Productions,Integer> {

    /**
     * Get list Productions
     * @author: AnHN
     * @date: 10-01-2024
     * @return List<Productions>
     */
    @Query(value = "select * from productions",nativeQuery = true)
    List<Productions> findAllProductions();
}
