package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.TypeProduct;

import java.util.List;

public interface IProductService {

    List<TypeProduct> findAllProduct();
}
