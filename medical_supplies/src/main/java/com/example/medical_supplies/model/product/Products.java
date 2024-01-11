package com.example.medical_supplies.model.product;

import jakarta.persistence.*;


@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private String supplier;

    private String ingredient;

    private String main_avatar;

    private String avatar_one;

    private String avatar_two;


    @ManyToOne
    @JoinColumn(name = "id_type_product", referencedColumnName = "id")
    private TypeProduct typeProduct;

    @ManyToOne
    @JoinColumn(name = "id_production", referencedColumnName = "id")
    private Productions productions;


    public Products() {
    }

    public Products(Long id, String name, Double price, Integer quantity, String supplier, String ingredient, String main_avatar, String avatar_one, String avatar_two, TypeProduct typeProduct, Productions productions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.ingredient = ingredient;
        this.main_avatar = main_avatar;
        this.avatar_one = avatar_one;
        this.avatar_two = avatar_two;
        this.typeProduct = typeProduct;
        this.productions = productions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMain_avatar() {
        return main_avatar;
    }

    public void setMain_avatar(String main_avatar) {
        this.main_avatar = main_avatar;
    }

    public String getAvatar_one() {
        return avatar_one;
    }

    public void setAvatar_one(String avatar_one) {
        this.avatar_one = avatar_one;
    }

    public String getAvatar_two() {
        return avatar_two;
    }

    public void setAvatar_two(String avatar_two) {
        this.avatar_two = avatar_two;
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
