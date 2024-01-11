package com.example.medical_supplies.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductController_getInfoProduct {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getListProducts() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getListProducts_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list?page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("a"))
                .andExpect(jsonPath("content[0].name").value("b"));
    }
    @Test
    public void getListProducts_nameProduct_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list?page=0&nameProduct=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
