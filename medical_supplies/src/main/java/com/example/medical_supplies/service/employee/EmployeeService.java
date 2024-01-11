package com.example.medical_supplies.service.employee;

import com.example.medical_supplies.controller.auth.model.auth.Employee;
import com.example.medical_supplies.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    /**
     * Retrieves an employee by employee ID.
     * @author: TrungND
     * @date: 10-01-2024
     * @param id The Employee ID.
     * @return The employee
     */
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
    /**
     * Retrieves an employee by Phone.
     * @author: TrungND
     * @date: 10-01-2024
     * @param phone the Employee Phone.
     * @return The employee findByPhone
     */
    @Override
    public Employee findEmployeeByPhone(String phone) {
        return employeeRepository.findEmployeeByPhone(phone);
    }
    /**
     * update an info Employee.
     * @author: TrungND
     * @date: 10-01-2024
     * @param employee
     * @return employee
     */
    @Override
    public void editEmployeeRepo(Employee employee) {
        employeeRepository.editEmployeeRepo(employee);
    }
}
