package com.example.medical_supplies.repository.employee;
import com.example.medical_supplies.model.auth.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository <Employee,Integer> {
}
