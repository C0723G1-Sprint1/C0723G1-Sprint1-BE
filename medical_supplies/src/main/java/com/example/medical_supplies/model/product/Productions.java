package com.example.medical_supplies.model.product;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Productions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProductions;

    @OneToMany(mappedBy = "products")
    private Set<Products> products;

    public Productions() {
    }

    public Productions(Long id, String nameProductions, Set<Products> products) {
        this.id = id;
        this.nameProductions = nameProductions;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProductions() {
        return nameProductions;
    }

    public void setNameProductions(String nameProductions) {
        this.nameProductions = nameProductions;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
