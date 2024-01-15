package com.example.medical_supplies.service.product;


import com.example.medical_supplies.model.product.TypeProduct;
import com.example.medical_supplies.repository.product.ITypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService{

    @Autowired
    private ITypeProductRepository iTypeProductRepository;

    /**
     * Author: AnHN.
     * This is the method to get the typeProduct list and search by name
     * return ResponseEntity and product or null
     */
    @Override
    public List<TypeProduct> findAllTypeProduct() {
        return iTypeProductRepository.findAllTypeProduct();
    }
}
