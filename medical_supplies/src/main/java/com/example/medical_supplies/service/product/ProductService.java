package com.example.medical_supplies.service.product;


import com.example.medical_supplies.dto.product.ProductDTO;
import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.repository.product.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Products> findAllProduct(Pageable pageable) {
        return iProductRepository.findAllProduct(pageable);
    }

    @Override
    public Products getProductById(Integer id) {
        return iProductRepository.getProductById(id);
    }

    @Override
    public boolean createProduct(ProductDTO productDTO) {
        try {
            iProductRepository.createProduct(productDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateProduct(ProductDTO productDTO) {
        try {
            iProductRepository.updateProduct(productDTO);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
