package com.example.medical_supplies.controller.auth;

import com.example.medical_supplies.dto.auth.AccountDTO;
import com.example.medical_supplies.dto.auth.JwtResponse;
import com.example.medical_supplies.dto.auth.LoginDTO;
import com.example.medical_supplies.model.auth.Account;
import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.model.auth.MyUserDetail;
import com.example.medical_supplies.model.auth.Role;
import com.example.medical_supplies.security.jwt.JwtUtils;
import com.example.medical_supplies.service.auth.IAccountService;
import com.example.medical_supplies.service.employee.IEmployeeService;
import com.example.medical_supplies.service.impl.MyUserDetailService;
import com.example.medical_supplies.utils.CodeEmployeeGenerator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class AuthController {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JwtUtils jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IEmployeeService employeeService;


    /**
     * Handles user login requests.
     *
     * @param accountDTO  The login request object.
     * @param bindingResult The result of the validation.
     * @return ResponseEntity containing the JWT response or map error messages.
     * @author: NamND
     * @date: 10/01/2024
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        loginDTO.validate(loginDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>("Thông tin đăng nhập không chính xác.", HttpStatus.UNAUTHORIZED);
        }
        try {
            myUserDetailService.loadUserByUsername(loginDTO.getEmail());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

            // Tạo đối tượng để trả về
            JwtResponse jwtResponse = new JwtResponse();
            BeanUtils.copyProperties(myUserDetail.getAccount(), jwtResponse);
            // Tạo Token cho đối tượng trả về;
            String jwt = jwtProvider.createToken((MyUserDetail) authentication.getPrincipal());
            jwtResponse.setAccessToken(jwt);

            // Lấy ra name Role trả về
            List<String> roles = myUserDetail.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            jwtResponse.setRoles(roles);
            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>("Thông tin đăng nhập không chính xác.", HttpStatus.UNAUTHORIZED);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Thông tin đăng nhập không chính xác.", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Register .
     *
     * @param accountDTO      The register request object.
     * @param bindingResult The result of the validation.
     * @author: NamND
     * @date: 11/01/2024
     * @return Messages successful or map error messages.
     */
    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        Map<String, String> accountDtoMap = new HashMap<>();
        new AccountDTO().validate(accountDTO, bindingResult);
        if (accountService.findByEmail(accountDTO.getEmail()).isPresent()){
            accountDtoMap.put("email","Email đã tồn tại");
        }
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                accountDtoMap.put(err.getField(), err.getDefaultMessage());
            }
        }
        if (accountDtoMap.size() != 0) {
            return new ResponseEntity<>(accountDtoMap, HttpStatus.CREATED);
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO,account);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
//        Thêm account
        Account accountNew = accountService.addAccount(account);
        if (accountNew==null){
            return new ResponseEntity<>("Thêm tài khoản thất bại.", HttpStatus.BAD_REQUEST);
        }
        //        Thêm account_role
        Role role = new Role();
        BeanUtils.copyProperties(accountDTO,role);
        accountService.addAccountRole(accountNew.getId(),role.getIdRole());

//        Thêm employee
          Employee employee = new Employee();
          BeanUtils.copyProperties(accountDTO,employee);
          employee.setCode(CodeEmployeeGenerator.generateCode());
          employee.setAccount(accountNew);
          employeeService.addEmployee(employee);
        return new ResponseEntity<>("Thêm tài khoản thành công", HttpStatus.OK);
    }

}
