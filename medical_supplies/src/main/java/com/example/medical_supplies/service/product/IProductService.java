package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService {

    /**
     * Get the list Products and search by product name, typeProduct, Productions
     * @author: AnHN
     * @date: 10-01-2024
     * @return Page<Products>
     */


    Page<Products> findAllProduct(Pageable pageable, String nameSearch,String typeProduct ,String nameProductions );
}
