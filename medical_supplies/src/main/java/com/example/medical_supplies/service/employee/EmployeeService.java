package com.example.medical_supplies.service.employee;

import com.example.medical_supplies.model.auth.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private
    @Override
    public Employee findEmployeeById(Integer id) {
        return null;
    }
}
