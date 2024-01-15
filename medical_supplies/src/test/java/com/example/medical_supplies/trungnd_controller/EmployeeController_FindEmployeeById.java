package com.example.medical_supplies.trungnd_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_FindEmployeeById {
    @Autowired
    MockMvc mockMvc;


    /**
     * create by TrungND
     * date 11/01/2024
     * goal: get employee with id equal 2
     * return HttpStatus 2xx
     */
    @Test
    public void get_Employee_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/{id}", "2")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * create by TrungND
     * date 11/01/2024
     * goal: get employee with id equal ""
     * return HttpStatus 4xx
     */
    @Test
    public void get_employee_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: get employee with id equal null
     * return HttpStatus 4xx
     */
    @Test
    public void get_employee_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: get employee with id is out of bound
     * return HttpStatus 4xx
     */
    @Test
    public void get_employee_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}","100"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
