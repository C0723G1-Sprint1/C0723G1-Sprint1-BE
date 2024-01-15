package com.example.medical_supplies.service.product;


import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    /**
     * Get the list Products and search by product name, typeProduct, Productions
     * @author: AnHN
     * @date: 10-01-2024
     * @return Page<Products>
     */



    @Override
    public Page<Products> findAllProduct(Pageable pageable, String nameSearch,  String typeProduct, String nameProductions ) {
        return iProductRepository.findAllProduct(pageable, "%"+nameSearch+"%","%"+typeProduct+"%","%"+nameProductions+"%");
    }

}
