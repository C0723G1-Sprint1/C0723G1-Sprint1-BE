package com.example.medical_supplies.controller.order;

import com.example.medical_supplies.dto.auth.AccountDTO;
import com.example.medical_supplies.dto.order.OrderDto;
import com.example.medical_supplies.model.auth.Account;
import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.model.auth.Role;
import com.example.medical_supplies.model.cart.Orders;
import com.example.medical_supplies.service.order.IOrderService;
import com.example.medical_supplies.utils.CodeEmployeeGenerator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/order")
@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<?> crearteOrder( @RequestBody OrderDto orderDTO) {
        LocalDateTime date = LocalDateTime.now();
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDTO, orders);
        orders.setDateOrder(date);
       Orders orderNew = orderService.createOrder(orders);





        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }
}
