package com.example.medical_supplies.service.employee;

import com.example.medical_supplies.model.auth.Employee;

public interface IEmployeeService {
    /**
     * method: findEmployeeById
     * create by TrungND
     * date 10-01-2024
     * param : id
     * return :
     */
    Employee findEmployeeById(Integer id);
    /**
     * method: findEmployeeByPhone
     * create by TrungND
     * date 10-01-2024
     * param : id
     * return :
     */
    Employee findEmployeeByPhone(String phone);
    /**
     * method: editEmployeeRepo
     * create by TrungND
     * date 10-01-2024
     * param : id
     * return :
     */
    void editEmployeeRepo(Employee employee);

    void save(Employee employee);
}
