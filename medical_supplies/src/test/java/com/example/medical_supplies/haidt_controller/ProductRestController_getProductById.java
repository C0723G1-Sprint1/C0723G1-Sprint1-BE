package com.example.medical_supplies.haidt_controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_getProductById {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getinfoProduct() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products/product/{id}",1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Máy tạo oxi"))
                .andExpect(jsonPath("$.price").value(10000));

    }
}
