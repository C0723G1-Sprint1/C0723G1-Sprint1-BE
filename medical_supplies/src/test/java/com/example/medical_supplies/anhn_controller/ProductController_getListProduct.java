package com.example.medical_supplies.anhn_controller;



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
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].name").value("Máy thở oxi"))
                .andExpect(jsonPath("content[0].price").value(500000))
                .andExpect(jsonPath("content[4].name").value("Áo choảng bảo hộ y tế"))
                .andExpect(jsonPath("content[4].price").value(200000))
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
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].name").value("Máy thở oxi"))
                .andExpect(jsonPath("content[0].price").value(500000));
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
                                .get("/api/products/list?page=0&size=5&name=Máy thở oxi"))
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
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[0].name").value("Máy thở oxi"))
                .andExpect(jsonPath("content[0].price").value(500000));
    }
}

