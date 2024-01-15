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
public class ProductController_getListProduct {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Author: AnHN.
     * This method is used to test for function findAllProduct connect with database
     * @Throws Exception
     */

    @Test
    public void getListProducts_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Author: AnHN.
     * This method is used to test for function finaAllProduct find the list
     * @Throws Exception
     */

    @Test
    public void getListProducts_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list?page=0&size=5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("a"))
                .andExpect(jsonPath("content[0].price").value(1))
                .andExpect(jsonPath("content[0].mainAvatar").value("a"))
                .andExpect(jsonPath("content[4].name").value("e"))
                .andExpect(jsonPath("content[4].price").value(5))
                .andExpect(jsonPath("content[4].mainAvatar").value("e"))
        ;
    }

    /**
     * Author: AnHN.
     * This method is used to test for function finaAllProduct with input param (name is empty)
     * @Throws Exception
     */

    @Test
    public void getListProducts_nameSearch_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list?page=0&size=5&name="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("a"))
                .andExpect(jsonPath("content[0].price").value(1))
                .andExpect(jsonPath("content[0].mainAvatar").value("a"));
    }

    /**
     * Author: AnHN.
     * This method is used to test for function finaAllProduct with input param (name is not existed)
     * @Throws Exception
     */

    @Test
    public void getListProducts_nameSearch_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list?page=0&size=5&name=t"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Author: AnHN.
     * This method is used to test for function finaAllProduct with input param (name is existed)
     * @Throws Exception
     */

    @Test
    public void getListProducts_nameSearch_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list?page=0&size=5&name=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Author: AnHN.
     * This method is used to test for function finaAllProduct with input param (name is null)
     * @Throws Exception
     */

    @Test
    public void getListProducts_nameSearch_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/products/list?page=0&size=5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].name").value("a"))
                .andExpect(jsonPath("content[0].price").value(1))
                .andExpect(jsonPath("content[0].mainAvatar").value("a"));
    }
}
