package com.example.medical_supplies.controller.product;

import com.example.medical_supplies.dto.product.ProductDTO;
import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;


    /**
     * Author: AnHN.
     * This is the method to get the product list and search by name
     * return ResponseEntity and product or null
     */
    @GetMapping("/list")
    public ResponseEntity<?> getAllProduct(
            @RequestParam(name = "nameProduct", defaultValue = "", required = false) String name,
            @RequestParam(name = "typeProduct", defaultValue = "", required = false) String type,
            @RequestParam(name = "productions", defaultValue = "", required = false) String productions,
            @RequestParam(defaultValue = "0", required = false) int page
    ) {
        Pageable pageable = PageRequest.of(page, 9);
        Page<Products> productPage = iProductService.findAllProduct(pageable, name, type, productions);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }


    /**
     * Author: HaiDT
     * This is the method add product
     * Create product
     **/
    @PostMapping("/create")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        boolean status = iProductService.createProduct(productDTO);
        if (!status) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Author: HaiDT.
     * This is the method update product.
     * Update one product
     **/
    @PatchMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        boolean status = iProductService.updateProduct(productDTO);
        if (!status) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Author: HaiDT
     * This is the method get product
     * Show product details
     **/
    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsProduct(@PathVariable Integer id) {
        Products products = iProductService.getProductById(id);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public List<Products> getListProduct() {
        List<Products> productsList = iProductService.getListProduct();
        return productsList;
    }


}
