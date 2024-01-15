package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.Productions;

import java.util.List;

public interface IProductions {

    /**
     * Author: AnHN.
     * This is the method to get the productions list and search by name
     * return ResponseEntity and product or null
     */
    List<Productions> findAllProductions();
}
