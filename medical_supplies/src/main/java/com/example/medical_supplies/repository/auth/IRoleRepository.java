package com.example.medical_supplies.repository.auth;

import com.example.medical_supplies.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Class IRoleRepository extends class JpaRepository.
 *
 * @author: NamND
 * @date: 10/01/2024
 */
public interface IRoleRepository extends JpaRepository<Role, Integer> {

    /**
     * Get Role by role
     *
     * @param role to find by name Role
     * @return Optional<Role>
     * @author: NamND
     * @date: 10/01/2024
     */
    @Query(value = "SELECT * FROM role WHERE role = :role", nativeQuery = true)
    Optional<Role> findByRole(@Param("role") String role);

    @Query(value = "SELECT * FROM role", nativeQuery = true)
    List<Role> findAll();
}
