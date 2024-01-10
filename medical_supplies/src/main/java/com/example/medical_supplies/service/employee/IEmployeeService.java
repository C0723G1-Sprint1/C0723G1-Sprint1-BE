package com.example.medical_supplies.service.employee;

import com.example.medical_supplies.model.auth.Employee;

public interface IEmployeeService {
    Employee findEmployeeById(Integer id);
}
