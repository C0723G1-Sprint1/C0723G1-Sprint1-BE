package com.example.medical_supplies.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Productions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameProductions;
    @JsonBackReference
    @OneToMany(mappedBy = "productions")
    private Set<Products> products;

    public Productions() {
    }

    public Productions(Integer id, String nameProductions, Set<Products> products) {
        this.id = id;
        this.nameProductions = nameProductions;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
