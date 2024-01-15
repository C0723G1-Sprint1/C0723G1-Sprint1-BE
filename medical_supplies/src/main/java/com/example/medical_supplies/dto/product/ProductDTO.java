package com.example.medical_supplies.dto.product;

import com.example.medical_supplies.model.product.Productions;
import com.example.medical_supplies.model.product.TypeProduct;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {

    private Long id;
    @NotNull
    private String name;
    @NotBlank
    @Min(value = 1000, message = "")
    private Double price;
    @NotBlank
    @Min(value = 1, message = "")
    private Integer quantity;
    @NotBlank
    private String supplier;
    @NotBlank
    private String ingredient;
    @NotBlank
    private String mainAvatar;
    @NotBlank
    private String avatarOne;
    @NotBlank
    private String avatarTwo;
    @NotBlank
    private Integer typeProduct;
    @NotBlank
    private Integer productions;

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

    private static final String REGEX_NAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*$";

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        //check validate for Product_name
        if (productDTO.getName() != null) {
            if (productDTO.getName().equals("")) {
                errors.rejectValue("name", "", "Vui lòng nhập");
            } else if (productDTO.getName().length() <= 3) {
                errors.rejectValue("name", "", "Không đủ độ dài");
            } else if (productDTO.getName().length() > 100) {
                errors.rejectValue("name", "", "Tên quá dài, không được quá 30 kí tự");
            } else if (!productDTO.getName().matches(REGEX_NAME)) {
                errors.rejectValue("name", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
            }
        }else if(productDTO.getName() == null){
            errors.rejectValue("name", "", "Vui lòng nhập");
        }
        //check validate for Product_price
        if (productDTO.getPrice() == null) {
            errors.rejectValue("price", "", "Vui lòng nhập");
        }

        // check validate for product_quantity
        if (productDTO.getQuantity() == null) {
            errors.rejectValue("quantity", "", "Vui lòng nhập");
        }
        // check validate for product_ingredient
        if (productDTO.getIngredient() == null) {
            errors.rejectValue("ingredient", "", "Vui lòng nhập");
        } else if (productDTO.getIngredient().trim().equals("")) {
            errors.rejectValue("ingredient", "", "Vui lòng nhập");
        } else if (productDTO.getIngredient().length() <= 3) {
            errors.rejectValue("ingredient", "", "Không đủ độ dài");
        } else if (productDTO.getIngredient().length() > 100) {
            errors.rejectValue("ingredient", "", "Tên thành phần quá dài, không được quá 100 kí tự");
        } else if (productDTO.getIngredient().matches(REGEX_NAME)) {
            errors.rejectValue("ingredient", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
        }

        // check validate for product_supplier
        if (productDTO.getSupplier() == null) {
            errors.rejectValue("supplier", "", "Vui lòng nhập");
        } else if (productDTO.getSupplier().trim().equals("")) {
            errors.rejectValue("supplier", "", "Vui lòng nhập");
        } else if (productDTO.getSupplier().length() < 3) {
            errors.rejectValue("supplier", "", "Tên nhà cung cấp không đủ độ dài");
        } else if (productDTO.getSupplier().length() > 100) {
            errors.rejectValue("supplier", "", "Tên nhà cung cấp quá dài, không được quá 100 kí tự");
        } else if (productDTO.getSupplier().matches(REGEX_NAME)) {
            errors.rejectValue("supplier", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
        }
    }

}
