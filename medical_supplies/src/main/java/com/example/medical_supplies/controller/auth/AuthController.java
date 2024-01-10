package com.example.medical_supplies.controller.auth;

import com.example.medical_supplies.dto.auth.AccountDTO;
import com.example.medical_supplies.model.auth.Account;
import com.example.medical_supplies.model.auth.MyUserDetail;
import com.example.medical_supplies.security.jwt.JwtUtils;
import com.example.medical_supplies.service.auth.IAccountService;
import com.example.medical_supplies.service.impl.MyUserDetailService;
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
    public ResponseEntity<?> login(@Valid @RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        accountDTO.validate(accountDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>("Thông tin đăng nhập không chính xác.", HttpStatus.UNAUTHORIZED);
        }
        try {
            myUserDetailService.loadUserByUsername(login.getUsername());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

            // Tạo đối tượng để trả về
            JwtResponse jwtResponse = new JwtResponse();
            BeanUtils.copyProperties(myUserDetail.getAccount(), jwtResponse);
            // Create Token cho đối tượng trả về;
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

}
