package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Productions;
import com.example.medical_supplies.model.product.TypeProduct;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductions {
    @Query(value = "select * from production",nativeQuery = true)
    List<Productions> findAllProductions();
}
