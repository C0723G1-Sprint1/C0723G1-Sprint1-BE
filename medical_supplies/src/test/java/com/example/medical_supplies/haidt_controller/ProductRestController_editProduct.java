package com.example.medical_supplies.haidt_controller;


import com.example.medical_supplies.dto.product.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_editProduct {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Creator: HaiDT
     * parameter Name = null
     * Goal: HttpStatus = 400
     * Date edit : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_name_19() throws Exception {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setName(null);
        productDTO.setPrice(10000.2);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setQuantity(100);
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setProductions(1);
        productDTO.setTypeProduct(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Name = ""
     * Goal: HttpStatus = 400
     * Date edit : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_name_20() throws Exception {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setName("");
        productDTO.setPrice(10000.2);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setQuantity(100);
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setProductions(1);
        productDTO.setTypeProduct(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Name wrong format
     * Goal: HttpStatus = 400
     * Date edit : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_name_21() throws Exception {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setName("@%@%*%");
        productDTO.setPrice(10000.2);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setQuantity(100);
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setProductions(1);
        productDTO.setTypeProduct(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Name min length
     * Goal: HttpStatus = 400
     * Date edit : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_name_22() throws Exception {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setName("Co");
        productDTO.setPrice(10000.2);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setQuantity(100);
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setProductions(1);
        productDTO.setTypeProduct(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Name max length
     * Goal: HttpStatus = 400
     * Date edit : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_name_23() throws Exception {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setName("Dkndccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        productDTO.setPrice(10000.2);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setQuantity(100);
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setProductions(1);
        productDTO.setTypeProduct(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter price = null
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_price_19()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(null);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter price min
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_price_22()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(100.0);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter quantity = null
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_quantity_19()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(null);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter quantity min
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_quantity_22()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter supplier = null
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_supplier_19()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier(null);
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter supplier = ""
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_supplier_20()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1l);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter supplier wrong format
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_supplier_21()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("@%&()%&#()");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter supplier min length
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_supplier_22()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("Dnf");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter supplier max length
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_supplier_23()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("Dnfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Ingredient = null
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_Ingredient_19()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("Dnfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        productDTO.setIngredient(null);
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Ingredient = ""
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_Ingredient_20()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("Dnfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        productDTO.setIngredient("");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Ingredient wrong format
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_Ingredient_21()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Dasssssssssssssssssssssss");
        productDTO.setPrice(1.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("Dnfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        productDTO.setIngredient("@$@)(%&@");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Ingredient min length
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_ingredient_22()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient("s");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Ingredient max length
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_ingredient_23()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient("Dssdkvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter TypeProduct = null
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_typeProduct_19()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient("sfdvdv");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(null);
        productDTO.setProductions(1);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter Productions = null
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_productions_19()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient("sfdvdv");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(null);
        productDTO.setId(1L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HaiDT
     * parameter Object News valid
     * Goal: HttpStatus = 200
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void editProduct_24() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("May Tao Oxi");
        productDTO.setPrice(5000000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("Viet");
        productDTO.setIngredient("Aaaa");
        productDTO.setMainAvatar("Bbbb");
        productDTO.setAvatarOne("Ccccc");
        productDTO.setAvatarTwo("Ddddd");
        productDTO.setTypeProduct(3);
        productDTO.setProductions(2);
        productDTO.setId(2L);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/products/update/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
