package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.TypeProduct;

import java.util.List;

public interface ITypeProductService {

    /**
     * Get list TypeProduct
     * @author: AnHN
     * @date: 10-01-2024
     * @return List<TypeProduct>
     */
    List<TypeProduct> findAllTypeProduct();
}
