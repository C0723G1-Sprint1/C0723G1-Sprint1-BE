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

@Query(value = "select * from employee where phone = :phone",nativeQuery = true)
    Employee findEmployeeByPhone(@Param("phone") String phone);

    @Transactional
    @Modifying
    @Query(value = "update employee set name = :#{#employee.name}, gender = :#{#employee.gender}, birthday = :#{#employee.birthday}, " +
            "phone = :#{#employee.phone}, address = :#{#employee.address} " +
            "WHERE id = :#{#employee.id}",nativeQuery = true)
    void editEmployeeRepo(@Param("employee") Employee employee);

    /**
     * Add employee
     * @author: NamND
     * @date: 11-01-2024
     * @param employee to add employee
     * @return boolean
     */
    @Transactional
    @Modifying
    @Query(value = "insert into employee (`code`,`name`,birthday,phone,address,gender,id_account) " +
            "values (:#{#employee.code},:#{#employee.name},:#{#employee.birthday}, :#{#employee.phone},:#{#employee.address}," +
            ":#{#employee.gender},:#{#employee.account.id})",nativeQuery = true)
    void addEmployeeRepo(@Param("employee") Employee employee);


}
