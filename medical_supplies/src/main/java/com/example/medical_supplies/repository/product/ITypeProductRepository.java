package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITypeProductRepository extends JpaRepository<TypeProduct,Long> {

    @Query(value = "select * from type_product",nativeQuery = true)
    List<TypeProduct> findAllTypeProduct();
}
