package com.example.medical_supplies.controller.product;


import com.example.medical_supplies.model.product.Productions;
import com.example.medical_supplies.model.product.TypeProduct;
import com.example.medical_supplies.service.product.IProductions;
import com.example.medical_supplies.service.product.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productions")
public class ProductionsController {

    @Autowired
    private IProductions productions;


    @GetMapping("/list")
    public ResponseEntity<?> getAllProduction(){
        List<Productions> productionsList = productions.findAllProductions();
        if (productionsList == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productionsList,HttpStatus.OK);
    }
}
