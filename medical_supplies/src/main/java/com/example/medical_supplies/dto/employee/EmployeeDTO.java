package com.example.medical_supplies.dto.employee;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Validator {
    private Integer id;
    private String code;
    private String name;
    private String birthday;
    private String phone;
    private String address;
    private boolean gender;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private static final String REGEX_PHONE = "^0[0-9]{9}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String REGEX_NAME = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*$";

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
        //check validate for employee's name
        if (employeeDTO.getName() == null) {
            errors.rejectValue("name", "", "Vui lòng nhập tên");
        } else if (employeeDTO.getName().trim().equals("")) {
            errors.rejectValue("name", "", "Vui lòng nhập tên");
        } else if (employeeDTO.getName().length() <= 2) {
            errors.rejectValue("name", "", "Tối thiểu 2 kí tự");
        } else if (employeeDTO.getName().length() > 30) {
            errors.rejectValue("name", "", "Tên quá dài, không được quá 30 kí tự");
        } else if (!employeeDTO.getName().matches(REGEX_NAME)) {
            errors.rejectValue("name", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
        }
        //check validate for birthday
        if (employeeDTO.getBirthday() == null) {
            errors.rejectValue("birthday", "", "Vui lòng nhập");
        } else if (employeeDTO.getBirthday().trim().equals("")) {
            errors.rejectValue("birthday", "", "Vui lòng nhập");
        } else if (!check5(employeeDTO.getBirthday())) {
            errors.rejectValue("birthday", "", "Phải lớn hơn 18 tuổi");
        } else if (!check100(employeeDTO.getBirthday())) {
            errors.rejectValue("birthday", "", "Phải bé hơn 65 tuổi");
        }
        // check validate for employee's phone
        if (employeeDTO.getPhone() == null) {
            errors.rejectValue("phone", "", "Vui lòng nhập");
        } else if (employeeDTO.getPhone().trim().equals("")) {
            errors.rejectValue("phone", "", "Vui lòng nhập");
        } else if (!employeeDTO.getPhone().matches(REGEX_PHONE)) {
            errors.rejectValue("phone", "", "SĐT bao gồm 10 số ex:012312312");
        }
        // check validate for employee's address
        if (employeeDTO.getAddress() == null) {
            errors.rejectValue("address", "", "Vui lòng nhập địa chỉ");
        } else if (employeeDTO.getAddress().trim().equals("")) {
            errors.rejectValue("address", "", "Vui lòng nhập địa chỉ");
        } else if (employeeDTO.getAddress().length() <= 5) {
            errors.rejectValue("address", "", "Địa chỉ phải có tối thiểu 5 kí tự");
        } else if (employeeDTO.getAddress().length() > 100) {
            errors.rejectValue("address", "", "Địa chỉ tối đa 100 kí tự");
        }
    }

    public boolean check5(String birthdayCus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(birthdayCus, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dob, currentDate);
        if (age.getYears() > 18) {
            return true;
        } else return false;
    }

    public boolean check100(String birthdayCus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(birthdayCus, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dob, currentDate);
        if (age.getYears() < 65) {
            return true;
        } else return false;
    }
}
