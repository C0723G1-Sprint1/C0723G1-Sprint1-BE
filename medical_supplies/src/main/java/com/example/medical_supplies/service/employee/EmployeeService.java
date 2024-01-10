package com.example.medical_supplies.service.employee;

import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee findEmployeeByPhone(String phone) {
        return employeeRepository.findEmployeeByPhone(phone);
    }

    @Override
    public void editEmployeeRepo(Employee employee) {
        employeeRepository.editEmployeeRepo(employee);
    }
}
