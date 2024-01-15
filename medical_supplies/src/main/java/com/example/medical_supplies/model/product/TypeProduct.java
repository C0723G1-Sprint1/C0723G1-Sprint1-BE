package com.example.medical_supplies.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class TypeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameTypeProduct;
    @JsonBackReference
    @OneToMany(mappedBy = "typeProduct")
    private Set<Products> products;

    public TypeProduct() {
    }

    public TypeProduct(Integer id, String nameTypeProduct, Set<Products> products) {
        this.id = id;
        this.nameTypeProduct = nameTypeProduct;
        this.products = products;
    }

    public TypeProduct(Integer typeProduct) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
