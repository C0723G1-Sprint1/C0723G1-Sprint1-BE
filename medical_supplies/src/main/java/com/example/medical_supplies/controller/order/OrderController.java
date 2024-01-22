package com.example.medical_supplies.controller.order;

import com.example.medical_supplies.dto.auth.AccountDTO;
import com.example.medical_supplies.dto.order.OrderDetailDto;
import com.example.medical_supplies.dto.order.OrderDto;
import com.example.medical_supplies.model.auth.Account;
import com.example.medical_supplies.model.auth.Customer;
import com.example.medical_supplies.model.auth.Employee;
import com.example.medical_supplies.model.auth.Role;
import com.example.medical_supplies.model.cart.OrderDetails;
import com.example.medical_supplies.model.cart.Orders;
import com.example.medical_supplies.model.product.Products;
import com.example.medical_supplies.service.customer.ICustomerService;
import com.example.medical_supplies.service.order.IOrderDetailService;
import com.example.medical_supplies.service.order.IOrderService;
import com.example.medical_supplies.service.product.IProductService;
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
import java.util.List;
import java.util.Map;

@RequestMapping("/api/orders")
@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDTO) {
        LocalDateTime date = LocalDateTime.now();
        Orders orders = new Orders();

        Customer customer = customerService.findCustomerById(orderDTO.getIdCustomer());
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orders.setCustomer(customer);
        orders.setDateOrder(date);
        Orders orderNew = orderService.createOrder(orders);

        if (orderNew != null) {
            OrderDetails orderDetail = new OrderDetails();
            for (OrderDetailDto o : orderDTO.getList()) {
                orderDetail.setOrder(orderNew);
                orderDetail.setQuantity(o.getAmount());
                orderDetail.setPrice(o.getPrice());
                Products products = productService.getProductById(o.getId());
                orderDetail.setProducts(products);
                orderDetailService.createOrderDetail(orderDetail);


            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
