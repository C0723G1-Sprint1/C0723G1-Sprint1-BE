package com.example.medical_supplies.model.product;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class TypeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTypeProduct;

    @OneToMany(mappedBy = "products")
    private Set<Products> products;

    public TypeProduct() {
    }

    public TypeProduct(Long id, String nameTypeProduct, Set<Products> products) {
        this.id = id;
        this.nameTypeProduct = nameTypeProduct;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
