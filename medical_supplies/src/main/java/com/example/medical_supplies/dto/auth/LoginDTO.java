package com.example.medical_supplies.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO implements Validator  {

    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "Email sai định dạng.")
    @Size(max = 40,message = "Email phải ít hơn hoặc bằng 40 ký tự")
    private String email;

//    @NotBlank(message = "Mật khẩu không được để trống.")
//    @Size(min = 8,message = "Mật khẩu phải từ 8 kí tự")
//    @Size(max = 20,message = "Mật khẩu phải ít hơn hoặc bằng 20 ký tự")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
