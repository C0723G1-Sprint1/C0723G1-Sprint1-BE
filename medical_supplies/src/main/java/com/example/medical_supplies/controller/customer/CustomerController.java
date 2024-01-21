package com.example.medical_supplies.controller.customer;

import com.example.medical_supplies.dto.auth.AccountDTO;
import com.example.medical_supplies.model.auth.Account;
import com.example.medical_supplies.model.auth.Customer;
import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.model.auth.Role;
import com.example.medical_supplies.service.auth.IAccountService;
import com.example.medical_supplies.service.customer.ICustomerService;
import com.example.medical_supplies.utils.CodeEmployeeGenerator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/customer")
@RestController
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        accountDTO.setName(accountDTO.getName().trim());
        new AccountDTO().validate(accountDTO, bindingResult);
        if (accountService.findByEmail(accountDTO.getEmail()).isPresent()) {
            errors.put("email", "Email đã tồn tại");
        }
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }
        if (errors.size() == 0) {
            Account account = new Account();
            BeanUtils.copyProperties(accountDTO, account);
            account.setPassword(passwordEncoder.encode(account.getPassword()));
//        Thêm account
            Account accountNew = accountService.addAccount(account);
            if (accountNew == null) {
                return new ResponseEntity<>("Thêm tài khoản thất bại.", HttpStatus.BAD_REQUEST);
            }
            //        Thêm account_role
            Role role = new Role();
            BeanUtils.copyProperties(accountDTO, role);
            accountService.addAccountRole(accountNew.getId(), role.getIdRole());

//        Thêm customer
            Customer customer = new Customer();
            BeanUtils.copyProperties(accountDTO, customer);
            customer.setCode(CodeEmployeeGenerator.generateCode());
            customer.setAccount(accountNew);
            customerService.saveCustomer(customer);
            return new ResponseEntity<>("Thêm tài khoản thành công", HttpStatus.OK);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/search/{email}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerService.findCustomerByEmail(email);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }
}
