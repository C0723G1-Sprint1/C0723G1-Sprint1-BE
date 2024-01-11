package com.example.medical_supplies.repository.employee;
import com.example.medical_supplies.model.auth.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository <Employee,Integer> {

    /**
     * Get Information Employee by Phone
     * @author: TrungND
     * @date: 10-01-2024
     * @param phone to find employee
     * @return Optional<Employee>
     */

@Query(value = "select * from employees where phone = :phone",nativeQuery = true)
    Employee findEmployeeByPhone(@Param("phone") String phone);

    @Transactional
    @Modifying
    @Query(value = "update employees set name = :#{#employee.name}, gender = :#{#employee.gender}, birthday = :#{#employee.birthday}, " +
            "phone = :#{#employee.phone}, address = :#{#employee.address} " +
            "WHERE id = :#{#employee.id}",nativeQuery = true)
    void editEmployeeRepo(@Param("employee") Employee employee);
}
