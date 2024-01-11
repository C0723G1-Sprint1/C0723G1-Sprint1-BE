package com.example.medical_supplies.dto.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Validator {
    private String code;
    @NotBlank(message = "Tên nhân viên không được để trống.")
    @Size(min = 8,message = "Mật khẩu phải từ 8 kí tự")
    @Size(max = 20,message = "Mật khẩu phải ít hơn hoặc bằng 20 ký tự")
    private String name;
    private String birthday;
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^(01|03|04|05|07|08|09)\\d{8}$",message = "Email sai định dạng.")
    private String phone;
    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;
    private Boolean gender;
    private Integer id_role;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
