package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.TypeProduct;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository  {

    @Query(value = "select * from products",nativeQuery = true)
    List<TypeProduct> findAllProduct();
}
