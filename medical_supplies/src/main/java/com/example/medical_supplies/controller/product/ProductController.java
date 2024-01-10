package com.example.medical_supplies.controller.product;

import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.model.product.TypeProduct;
import com.example.medical_supplies.service.product.IProductService;
import com.example.medical_supplies.service.product.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private IProductService iProductService;

//    @GetMapping("/list/product")
//    public ResponseEntity<?> getAllProduct(
//            @RequestParam(name = "nameCustomer", defaultValue = "", required = false) String name,
//            @RequestParam(name = "typeCustomer", defaultValue = "", required = false) String typeCustomer,
//            @RequestParam(name = "typeCustomer", defaultValue = "", required = false) String typeCustomer,
//            @RequestParam(defaultValue = "0", required = false) int page
//    ) {
//        Pageable pageable = PageRequest.of(page, 5);
//        List<Products> customerDto = iProductService.findAllProduct();
//        if (customerDto.isEmpty()) {
//            return new (HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(customerDto, HttpStatus.OK);
//        }
//    }
}
