package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Productions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IProductionsRepository extends JpaRepository<Productions,Long> {
    @Query(value = "select * from productions",nativeQuery = true)
    List<Productions> findAllProductions();
}
