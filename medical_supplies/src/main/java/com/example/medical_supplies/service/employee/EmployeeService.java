package com.example.medical_supplies.service.employee;

import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * Retrieves an employee by employee ID.
     *
     * @param id The Employee ID.
     * @return The employee
     * @author: TrungND
     * @date: 10-01-2024
     */
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves an employee by Phone.
     *
     * @param phone the Employee Phone.
     * @return The employee findByPhone
     * @author: TrungND
     * @date: 10-01-2024
     */
    @Override
    public Employee findEmployeeByPhone(String phone) {
        return employeeRepository.findEmployeeByPhone(phone);
    }

    /**
     * update an info Employee.
     *
     * @param employee
     * @return employee
     * @author: TrungND
     * @date: 10-01-2024
     */
    @Override
    public void editEmployeeRepo(Employee employee) {
        employeeRepository.editEmployeeRepo(employee);
    }
    /**
     * update an info Employee.
     * @author: NamND
     * @date: 11-01-2024
     * @param employee
     * @return emploue if adding new employee successfully,otherwise null
     */
    @Override
    public void addEmployee(Employee employee) {
        try {
           employeeRepository.addEmployeeRepo(employee);
        }catch (Exception e){
            e.getMessage();
        }
    }
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }



}
