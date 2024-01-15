package com.example.medical_supplies.trungnd_controller;

import com.example.medical_supplies.dto.auth.ChangePasswordDTO;
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
public class AuthController_ChangePassword {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with oldPassword is null
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_19_1() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword(null);
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/api/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with newPassword is null
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_19_2() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword(null);
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with newPassword is null
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_19_3() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with oldPassword is empty
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_20_4() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with newPassword is empty
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_20_5() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("");
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with againPassword is empty
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_20_6() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with oldPassword wrong format
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_21_7() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("ann321");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with newPassword wrong format
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_21_8() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("ann123");
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with againNewPassword wrong format
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_21_9() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("ann123");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with oldPassword not correct
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_21_10() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann31@");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with againNewPassword not correct
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_21_11() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("Ann133@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with least min length NewPassword
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_22_12() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("A123@");
        changePasswordDTO.setAgainNewPassword("A123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with over max length NewPassword
     * return HttpStatus 4xx
     */
    @Test
    public void changePassword_22_13() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("Annnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn123@");
        changePasswordDTO.setAgainNewPassword("Annnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * create by TrungND
     * date 11/01/2024
     * goal: changePassword with information correct
     * return HttpStatus 2xx
     */
    @Test
    public void changePassword_24() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setPassword("Ann321@");
        changePasswordDTO.setNewPassword("Ann123@");
        changePasswordDTO.setAgainNewPassword("Ann123@");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
