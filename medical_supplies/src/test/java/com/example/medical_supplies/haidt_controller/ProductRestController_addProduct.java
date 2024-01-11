package com.example.medical_supplies.haidt_controller;


import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.model.product.TypeProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_addProduct {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createProduct() throws Exception {

        TypeProduct typeProduct = new TypeProduct();
        Products products = new Products();

        products.setName("Hải");
        products.setPrice(100.000);
        products.setQuantity(10);
        products.setSupplier("sdvhslv");
        products.setAvatar_one("svsvsdvsd");
        products.setAvatar_two("svsvsdvsd");
        products.setMain_avatar("svsvsdvsd");
        products.setIngredient("dvsvvdvsd");
        products.setTypeProduct(typeProduct);

    }


}
