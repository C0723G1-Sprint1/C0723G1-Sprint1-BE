package com.example.medical_supplies.service.product;

import com.example.medical_supplies.model.product.Productions;
import com.example.medical_supplies.repository.product.IProductionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionsServiceService implements IProductionsService {

    @Autowired
    private IProductionsRepository iProductionsRepository;

    @Override
    public List<Productions> findAllProductions() {
        return iProductionsRepository.findAllProductions();
    }
}
