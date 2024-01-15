package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.Productions;

import java.util.List;

public interface IProductionsService {

    /**
     * Get list TypeProduct
     * @author: AnHN
     * @date: 10-01-2024
     * @return List<TypeProduct>
     */
    List<Productions> findAllProductions();
}
