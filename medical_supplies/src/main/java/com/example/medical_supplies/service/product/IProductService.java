package com.example.medical_supplies.service.product;

import com.example.medical_supplies.dto.product.ProductDTO;
import com.example.medical_supplies.model.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    /**
     * Author: AnHN.
     * This is the method to get the product list and search by name
     * return ResponseEntity and product or null
     */
    Page<Products> findAllProduct(Pageable pageable, String nameSearch,String typeProduct ,String nameProductions );

    Products getProductById(Integer id);

    boolean createProduct(ProductDTO productDTO);

    boolean updateProduct(ProductDTO productDTO);

    List<Products> getListProduct();
}
