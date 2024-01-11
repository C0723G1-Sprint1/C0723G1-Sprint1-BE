package com.example.medical_supplies.namnd_controller;

import com.example.medical_supplies.dto.auth.AccountDTO;
import com.example.medical_supplies.dto.auth.LoginDTO;
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
public class AuthController_register {
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
    public void regester_email_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail(null);
        accountDTO.setPassword("123456789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(2);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/register")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_email_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("");
        accountDTO.setPassword("123456789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_email_15() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("aerwe_gmail.com");
        accountDTO.setPassword("123456789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_email_16() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("aerwe");
        accountDTO.setPassword("123456789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_email_17() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("aerwedfgtrytrtdfgfhghgdfrtyhtrtrtrtrtrtrtrtrtfgdgrtytg@gmail.com");
        accountDTO.setPassword("123456789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_password_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword(null);
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(2);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/register")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_password_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_password_15() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("12345@#$$#6789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_password_16() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("12789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
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
    public void regester_password_17() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("12345dfsdfdsfsdfsdfsdfsdfsdfsderewsae6789");
        accountDTO.setName("Nguyễn Kiều MY");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * @Creator: NamND
     * @parameter name equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_name_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName(null);
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(2);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/register")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter name is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_name_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter name is not in correct format
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_name_15() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Nguyễn Kiều My @#$#");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter name is not less than or equal to max length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_name_17() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Nguyễn Kiều MY dfsdfsdfsdfsdfsdfsdfsđfwẻwédvfxcvxvxcvxcvsđâsqwedwefsdfsdfsdfzxczxcsdfsdaewefsdfsdasdfsfsdfsd");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter birthday equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_birthday_14_birthday_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday(null);
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(2);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/register")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter birthday is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_birthday_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @Creator: NamND
     * @parameter birthday must be greater than or equal to 18 years old
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_birthday_98() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("2010-02-10");
        accountDTO.setPhone("0833385469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter phone equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_phone_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("2000-02-10");
        accountDTO.setPhone(null);
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(2);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/register")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter phone is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_phone_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("2000-03-10");
        accountDTO.setPhone("");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @Creator: NamND
     * @parameter phone is not in correct format
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_phone_15() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("2010-02-10");
        accountDTO.setPhone("063338546945sdfgdf");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter address equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_address_13() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("2000-02-10");
        accountDTO.setPhone("0834571457");
        accountDTO.setAddress(null);
        accountDTO.setGender(true);
        accountDTO.setIdRole(2);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/register")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: NamND
     * @parameter address is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void regester_address_14() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("2000-03-10");
        accountDTO.setPhone("0834571457");
        accountDTO.setAddress("");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    /**
     * @Creator: NamND
     * @parameter regester successful
     * @Goal: HttpStatus = 2xx
     * @Throw:
     */
    @Test
    public void regester_18() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("thanhtam123@gmail.com");
        accountDTO.setPassword("tam123456789");
        accountDTO.setName("Võ Thanh Tâm");
        accountDTO.setBirthday("2006-01-11");
        accountDTO.setPhone("0833334469");
        accountDTO.setAddress("Quảng Bình");
        accountDTO.setGender(true);
        accountDTO.setIdRole(1);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/regester")
                                .content(this.objectMapper.writeValueAsString(accountDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
