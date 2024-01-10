package com.example.medical_supplies.service.product;


import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.model.product.TypeProduct;
import com.example.medical_supplies.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Products> findAllProduct(Pageable pageable) {
        return iProductRepository.findAllProduct(pageable);
    }
}
