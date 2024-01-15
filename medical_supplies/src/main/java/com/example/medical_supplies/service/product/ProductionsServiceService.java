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

    /**
     * Get list TypeProduct
     * @author: AnHN
     * @date: 10-01-2024
     * @return List<TypeProduct>
     */

    @Override
    public List<Productions> findAllProductions() {
        return iProductionsRepository.findAllProductions();
    }
}
