package com.example.medical_supplies.dto.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Validator {
    private static final String REGEX_NAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*$";
    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email sai định dạng.")
    @Size(min = 15, message = "Mật khẩu phải từ 15 kí tự")
    @Size(max = 40, message = "Email phải ít hơn hoặc bằng 45 ký tự")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống.")
    @Pattern(regexp = "^\\w+$", message = "Mật khẩu không chứa ký tự đặc biệt.")
    @Size(min = 8, message = "Mật khẩu phải từ 8 kí tự")
    @Size(max = 20, message = "Mật khẩu phải ít hơn hoặc bằng 20 ký tự")
    private String password;
    @NotBlank(message = "Tên nhân viên không được để trống.")
    @Pattern(regexp = REGEX_NAME, message = "Tên không chứa ký tự đặc biệt.")
    @Size(max = 20, message = "Mật khẩu phải ít hơn hoặc bằng 50 ký tự")
    private String name;
    @NotBlank(message = "Tên nhân viên không được để trống.")
    private String birthday;
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^(01|03|04|05|07|08|09)\\d{8}$", message = "Email sai định dạng.")
    private String phone;
    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;
    private Boolean gender;
    @NotNull(message = "")
    private Integer idRole;

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

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDTO accountDTO = (AccountDTO) target;
        if (accountDTO.birthday != null) {
            if (!accountDTO.birthday.equals("")) {
                if (!checkDob(accountDTO.getBirthday())) {
                    errors.rejectValue("birthday", null, "Nhân viên phải đủ 18 tuổi");
                }
            }
        }

    }

    public boolean checkDob(String birthdayCus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(birthdayCus, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dob, currentDate);
        if (age.getYears() >= 18) {
            return true;
        } else return false;
    }
}
