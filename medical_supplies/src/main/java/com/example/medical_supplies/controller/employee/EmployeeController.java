package com.example.medical_supplies.controller.employee;

import com.example.medical_supplies.dto.employee.EmployeeDTO;
import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.service.employee.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/employee")
@CrossOrigin("**")
@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id, BindingResult bindingResult) {
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        Map<String, String> employeeDtoMap = new HashMap<>();
        new EmployeeDTO().validate(employeeDTO, bindingResult);
        if (!employee.getPhone().equals(employeeDTO.getPhone())) {
            Employee employeeCheckPhone = employeeService.findEmployeeByPhone(employeeDTO.getPhone());
            if (employeeCheckPhone != null) {
                employeeDtoMap.put("phone", "Số điện thoại đã được đăng kí");
            }
        }

    }

}
