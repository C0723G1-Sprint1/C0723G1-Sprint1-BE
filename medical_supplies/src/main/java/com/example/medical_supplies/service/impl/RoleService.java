package com.example.medical_supplies.service.impl;

import com.example.medical_supplies.controller.auth.model.auth.Role;
import com.example.medical_supplies.repository.auth.IRoleRepository;
import com.example.medical_supplies.service.auth.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    /**
     * This method finds a role by name.
     * @author: NamND
     * @date: 10/01/2024
     * @param role The name of the role.
     * @return An optional containing the role if found, or an empty optional if not found.
     */
    @Override
    public Optional<Role> findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<Role> findRole() {

        return roleRepository.findAll();
    }
}
