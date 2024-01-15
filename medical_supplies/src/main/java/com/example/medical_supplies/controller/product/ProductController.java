package com.example.medical_supplies.controller.product;

import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    /**
     * method getAllProduct
     * @author: AnHN
     * @date: 10-01-2024
     * @return Page<Products>
     */
    @GetMapping("/list")
    public ResponseEntity<?> getAllProduct(
            @RequestParam(name = "nameProduct", defaultValue = "", required = false) String name,
            @RequestParam(name = "typeProduct", defaultValue = "", required = false) String type,
            @RequestParam(name = "productions", defaultValue = "", required = false) String productions,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 9);
        Page<Products> productPage = iProductService.findAllProduct(pageable,name,type,productions);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }

}
