package com.example.medical_supplies.model.product;

import jakarta.persistence.*;

@Entity
public class Products {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;

        private Double price;

        private Integer quantity;

        private String supplier;

        private String ingredient;

        private String mainAvatar;

        private String avatarOne;

        private String avatarTwo;


        @ManyToOne
        @JoinColumn(name = "id_type_product", referencedColumnName = "id")
        private TypeProduct typeProduct;

        @ManyToOne
        @JoinColumn(name = "id_production", referencedColumnName = "id")
        private Productions productions;


        public Products() {
        }

    public Products(Integer id, String name, Double price, Integer quantity, String supplier, String ingredient, String mainAvatar, String avatarOne, String avatarTwo, TypeProduct typeProduct, Productions productions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.ingredient = ingredient;
        this.mainAvatar = mainAvatar;
        this.avatarOne = avatarOne;
        this.avatarTwo = avatarTwo;
        this.typeProduct = typeProduct;
        this.productions = productions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMainAvatar() {
        return mainAvatar;
    }

    public void setMainAvatar(String mainAvatar) {
        this.mainAvatar = mainAvatar;
    }

    public String getAvatarOne() {
        return avatarOne;
    }

    public void setAvatarOne(String avatarOne) {
        this.avatarOne = avatarOne;
    }

    public String getAvatarTwo() {
        return avatarTwo;
    }

    public void setAvatarTwo(String avatarTwo) {
        this.avatarTwo = avatarTwo;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Productions getProductions() {
        return productions;
    }

    public void setProductions(Productions productions) {
        this.productions = productions;
    }
}
