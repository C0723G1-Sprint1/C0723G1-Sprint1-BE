package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    /**
     * Author: AnHN.
     * This is the method to get the product list and search by name
     * return ResponseEntity and product or null
     */
    Page<Products> findAllProduct(Pageable pageable, String nameSearch,String typeProduct ,String nameProductions );
}
