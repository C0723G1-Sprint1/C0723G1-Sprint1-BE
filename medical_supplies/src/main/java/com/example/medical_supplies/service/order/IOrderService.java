package com.example.medical_supplies.service.order;

import com.example.medical_supplies.model.cart.Orders;

public interface IOrderService {
    Orders createOrder(Orders orders);
}
