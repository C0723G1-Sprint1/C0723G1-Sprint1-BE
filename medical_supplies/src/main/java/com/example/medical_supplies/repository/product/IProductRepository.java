package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Products,Long> {

    @Query(value = "select * from products",nativeQuery = true)
    Page<Products> findAllProduct(Pageable pageable);
}
