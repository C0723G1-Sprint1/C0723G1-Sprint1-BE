package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.TypeProduct;

import java.util.List;

public interface ITypeProductService {

    /**
     * Author: AnHN.
     * This is the method to get the typeProduct list and search by name
     * return ResponseEntity and product or null
     */
    List<TypeProduct> findAllTypeProduct();
}
