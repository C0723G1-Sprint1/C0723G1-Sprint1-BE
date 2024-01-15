package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.Productions;
import com.example.medical_supplies.repository.product.IProductionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionsService implements IProductions{

    @Autowired
    private IProductionsRepository iProductionsRepository;

    /**
     * Author: AnHN.
     * This is the method to get the productions list and search by name
     * return ResponseEntity and product or null
     */

    @Override
    public List<Productions> findAllProductions() {
        return iProductionsRepository.findAllProductions();
    }
}
