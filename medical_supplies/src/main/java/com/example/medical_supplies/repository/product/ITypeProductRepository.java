package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITypeProductRepository extends JpaRepository<TypeProduct,Integer> {


    /**
     * Get list TypeProduct
     * @author: AnHN
     * @date: 10-01-2024
     * @return List<TypeProduct>
     */

    @Query(value = "select * from type_product",nativeQuery = true)
    List<TypeProduct> findAllTypeProduct();
}
