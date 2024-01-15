package com.example.medical_supplies.haidt_controller;
import com.example.medical_supplies.dto.product.ProductDTO;
import com.example.medical_supplies.model.product.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_addProduct {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator: HaiDT
     * parameter name = null
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void addProduct_name_13() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(null);
        productDTO.setPrice(10000.2);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator: HaiDT
     * parameter name = ""
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */


    @Test
    public void addProduct_name_14()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("");
        productDTO.setPrice(10000.2);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator: HaiDT
     * parameter name wrong format
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void addProduct_name_15()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("!@$($&(@$)@$_)");
        productDTO.setPrice(10000.2);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator: HaiDT
     * parameter name min length
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void addProduct_name_16()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("a");
        productDTO.setPrice(10000.2);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
                                .content(this.objectMapper.writeValueAsString(productDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Creator: HaiDT
     * parameter name max length
     * Goal: HttpStatus = 400
     * Date create : 12-01-2024
     * @Throw: Exception
     */
    @Test
    public void addProduct_name_17()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("aaaaaaaaaaaaaaaaaaaahfdsgjfhdsjxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxsssssssssssssssfhsdjfksjdhfksjhfsssssssssssssssssssssssssssssssssskjsdfjshdkfjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjsasss");
        productDTO.setPrice(10000.2);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_price_13()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(null);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_price_16()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(1000.0);
        productDTO.setQuantity(100);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_quantity_13()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(null);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_quantity_16()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(0);
        productDTO.setSupplier("sdcsdvs");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_supplier_13()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier(null);
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_supplier_14()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_supplier_15()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("736765$$#$%#%$");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_supplier_16()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("a");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_supplier_17()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_ingredient_13()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient(null);
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_ingredient_14()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient("");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_ingredient_15()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient("%%%%%%%%%&%$##%$^");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_ingredient_16()throws Exception{
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
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_ingredient_17()throws Exception{
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("asssssssssssssssssssssss");
        productDTO.setPrice(10000.0);
        productDTO.setQuantity(10);
        productDTO.setSupplier("ssssssssssssssssssssssssssss");
        productDTO.setIngredient("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_typeProduct_13()throws Exception{
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
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_productions_13()throws Exception{
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
        productDTO.setProductions(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/products/create/product")
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
    public void addProduct_18() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("May Tao Oxi");
        productDTO.setPrice(5000000.000);
        productDTO.setQuantity(10);
        productDTO.setSupplier("Viee");
        productDTO.setIngredient("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setMainAvatar("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarOne("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setAvatarTwo("dsvdfsvvrvvklwjvlwjvs");
        productDTO.setTypeProduct(1);
        productDTO.setProductions(1);
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/products/create/product")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }



}
