package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITypeProductRepository extends JpaRepository<TypeProduct,Integer> {

}
