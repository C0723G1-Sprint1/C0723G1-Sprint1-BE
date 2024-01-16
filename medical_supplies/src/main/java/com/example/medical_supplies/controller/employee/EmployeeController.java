package com.example.medical_supplies.controller.employee;

import com.example.medical_supplies.dto.employee.EmployeeDTO;
import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.model.auth.MyUserDetail;
import com.example.medical_supplies.service.employee.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/employee")
@CrossOrigin("*")
@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    /**
     * method updateEmployee
     * create by TrungND
     * date 10-1-2024
     * param :id
     * return ResponseEntity and employee or null
     */
    @PatchMapping("/{id}")
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
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                employeeDtoMap.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(bindingResult.getAllErrors().toString(), HttpStatus.NOT_ACCEPTABLE);
        }
        if (employeeDtoMap.size() != 0) {
            return new ResponseEntity<>(employeeDtoMap, HttpStatus.CREATED);
        }
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setId(id);
        employeeService.editEmployeeRepo(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * method getEmployeeById
     * create by TrungND
     * date 10-1-2024
     * param :id
     * return ResponseEntity and employee or null
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            employeeService.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @GetMapping("/search/{email}")
    public ResponseEntity<?> getEmployeeByEmail(@PathVariable String email) {
        Employee employee = employeeService.findEmployeeByEmail(email);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

}
