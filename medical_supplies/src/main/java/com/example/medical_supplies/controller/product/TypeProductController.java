package com.example.medical_supplies.controller.product;


import com.example.medical_supplies.service.product.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TypeProductController {
    @Autowired
    private ITypeProductService iTypeProductService;
}
