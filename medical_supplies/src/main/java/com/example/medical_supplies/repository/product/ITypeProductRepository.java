package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITypeProductRepository extends JpaRepository<TypeProduct,Long> {

    /**
     * Author: HaiDT.
     * This is the method to get the typeProduct list and search by name
     * return ResponseEntity and product or null
     */
    @Query(value = "select * from type_product",nativeQuery = true)
    List<TypeProduct> findAllTypeProduct();
}
