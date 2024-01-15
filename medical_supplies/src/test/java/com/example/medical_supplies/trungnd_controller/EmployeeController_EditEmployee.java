package com.example.medical_supplies.trungnd_controller;

import com.example.medical_supplies.dto.employee.EmployeeDTO;
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
public class EmployeeController_EditEmployee {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with employee equal null
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_19() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(null))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with employee equal ""
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_20() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(""))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with empty field name
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_20_1() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/api/employee/edit/{id}",1)
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with empty field birthday
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_20_2() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn abc");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with empty field Phone
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_20_3() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn abc");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with empty field Address
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_20_4() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn abc");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with wrong format field Name
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_1() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn @");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }/**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with over max length field Name
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_2() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A Nguyễn Văn A Nguyễn Văn A Nguyễn Văn A Nguyễn Văn A Nguyễn Văn A Nguyễn Văn A Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with less than min length field Name
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_3() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("N");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with null field Name
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_12() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName(null);
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with under 18 age field Birthday
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_4() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("2007-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with over 65 age field Birthday
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_5() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1958-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with null field Birthday
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_11() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday(null);
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with wrong format field Phone
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_6() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("123123");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with input word in field Phone
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_7() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("abc");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with null in field Phone
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_8() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone(null);
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with empty in field address
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_9() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with null field address
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_10() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with less than min length field address
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_13() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("5A");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: edit employee with over max length field address
     * return HttpStatus 4xx
     */
    @Test
    public void edit_Employee_21_14() throws Exception{
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn A");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng 111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/employee/edit/{id}",1)
                                .content(this.objectMapper.writeValueAsString(employeeDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void edit_Employee_24() throws Exception{
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCode("NV001");
        employeeDTO.setName("Nguyễn Văn Abc");
        employeeDTO.setGender(true);
        employeeDTO.setBirthday("1990-01-01");
        employeeDTO.setPhone("0987654321");
        employeeDTO.setAddress("111 Đường An Thượng 5, Quận Sơn Trà, Thành phố Đà Nẵng");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/api/employee/edit/{id}",1)
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
