package com.example.medical_supplies.dto.product;

import com.example.medical_supplies.model.product.Productions;
import com.example.medical_supplies.model.product.TypeProduct;
import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {
    private static final String REGEX_NAME = "^[A-Z]\\w*\\s?(\\w*\\s?){1,50}$";
    private Integer id;
    @NotBlank(message = "Tên vật tư không được để trông,khoảng trắng hoặc null")
    @Pattern(regexp = REGEX_NAME,message = "Tên nhà cung không đúng định dạng hoặc chứa kí tự đặc biệt")
    @Min(value = 3,message = "Tên nhà cung cấp phải dài hơn 3 ký tự")
    @Max(value = 100,message = "Tên nhà cung quá dài, không được quá 100 kí tự")
    private String name;
    @NotBlank(message = "Giá vật tư không được để trống,khoảng trắng ")
    @Min(value = 1000, message = "Giá vật tư phải lớn hơn 1000 VNĐ")
    private Double price;
    @NotBlank(message = "Số lượng vật tư không được để trống,khoảng trắng")
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private Integer quantity;
    @NotBlank(message = "Tên nhà cung cấp vật tư không được để trống,khoảng trắng ")
    @Pattern(regexp = REGEX_NAME,message = "Tên nhà cung không đúng định dạng hoặc chứa kí tự đặc biệt")
    private String supplier;
    @NotBlank(message = "Thành phần vật tư không được để trống,khoảng trắng ")
    private String ingredient;
    @NotBlank(message = "Ảnh không được để trống")
    private String mainAvatar;
    private String avatarOne;
    private String avatarTwo;
    @NotBlank(message = "Tên loại tư không được để trống,khoảng trắng ")
    private Integer typeProduct;
    @NotBlank(message = "Tên nhà sản xuất vật tư không được để trống,khoảng trắng ")
    private Integer productions;

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

    public Integer getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(Integer typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Integer getProductions() {
        return productions;
    }

    public void setProductions(Integer productions) {
        this.productions = productions;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }

}
