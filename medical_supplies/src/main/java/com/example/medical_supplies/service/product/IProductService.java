package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<Products> findAllProduct(Pageable pageable);
}
