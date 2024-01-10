package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productions implements IProductions{

    @Autowired
    private IProductions iProductions;

    @Override
    public List<TypeProduct> findAllProductions() {
        return iProductions.findAllProductions();
    }
}
