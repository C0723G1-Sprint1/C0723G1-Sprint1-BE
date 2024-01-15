package com.example.medical_supplies.controller.auth;

import com.example.medical_supplies.dto.auth.AccountDTO;
import com.example.medical_supplies.dto.auth.ChangePasswordDTO;
import com.example.medical_supplies.dto.auth.JwtResponse;
import com.example.medical_supplies.dto.auth.LoginDTO;
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
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * Handles user login requests.
     *
     * @param loginDTO      The login request object.
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
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
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
    /**
     * method changePassword
     * create by TrungND
     * date 11-1-2024
     * param : changPasswordDTO, bindingResult
     * return:  ResponseEntity response or map errors message
     */
    @PatchMapping("/changePassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDTO changePasswordDTO, BindingResult bindingResult, Principal principal) {
        Map<String, String> errors = new HashMap<>();
        if (changePasswordDTO.getNewPassword()==null || changePasswordDTO.getNewPassword().equals("")){
            errors.put("newPassword", "Mật khẩu mới không được trống hoặc null");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        changePasswordDTO.validate(changePasswordDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("hongnhung123@gmail.com", changePasswordDTO.getPassword()));
            Account account = accountService.findByEmail(authentication.getName()).get();
            account.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
            accountService.updatePassword(account);
            return new ResponseEntity<>("Doi mat khau thanh cong!", HttpStatus.OK);
        } catch (BadCredentialsException e) {
            errors.put("password", "Mat khau cu khong chinh xac.");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
    }

}
