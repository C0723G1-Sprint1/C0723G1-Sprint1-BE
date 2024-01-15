package com.example.medical_supplies.controller.product;


import com.example.medical_supplies.model.product.TypeProduct;
import com.example.medical_supplies.service.product.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/type_products")
public class TypeProductController {
    @Autowired
    private ITypeProductService typeProductService;


    @GetMapping("/list")
    public ResponseEntity<?> getTypeProducts(){
        List<TypeProduct> typeProductList = typeProductService.findAllTypeProduct();
        if (typeProductList == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(typeProductList,HttpStatus.OK);
    }
}
