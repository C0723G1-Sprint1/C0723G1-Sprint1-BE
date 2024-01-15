package com.example.medical_supplies.namnd_controller;

import com.example.medical_supplies.dto.auth.LoginDTO;
import com.example.medical_supplies.model.auth.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthController_login {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Creator: NamND
     * @parameter email equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_email_13() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(null);
        loginDTO.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter email is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_email_14() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("");
        loginDTO.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter email is not in correct format
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_email_15() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("aerwe_gmail.com");
        loginDTO.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter email is not greater than or equal to min length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_email_16() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("aerwe");
        loginDTO.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter email is not less than or equal to max length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_email_17() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("aerwedfgtrytrtdfgfhghgdfrtyhtrtrtrtrtrtrtrtrtfgdgrtytg@gmail.com");
        loginDTO.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter email does not exist in the database
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_email_99() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("kieumy34123@gmail.com");
        loginDTO.setPassword("my941998");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter password equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_13() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("kieumy34123@gmail.com");
        loginDTO.setPassword(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter password is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_14() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("kieumy34123@gmail.com");
        loginDTO.setPassword("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter password is not in correct format
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_15() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("kieumy34123@gmail.com");
        loginDTO.setPassword("dfsd&$*");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter password is not greater than or equal to min length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_16() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("kieumy34123@gmail.com");
        loginDTO.setPassword("1234567");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter password is not less than or equal to max length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_17() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("kieumy34123@gmail.com");
        loginDTO.setPassword("123456789fgdfgbdfgderteryhsdvfsfgyhjghj");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter login successful
     * @Goal: HttpStatus = 2xx
     * @Throw:
     */
    @Test
    public void login_email_password_18() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("kieumy123@gmail.com");
        loginDTO.setPassword("my941998");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(loginDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
