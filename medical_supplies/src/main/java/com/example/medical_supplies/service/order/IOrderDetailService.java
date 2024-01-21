package com.example.medical_supplies.service.order;

import com.example.medical_supplies.model.cart.OrderDetails;
import com.example.medical_supplies.model.cart.Orders;

public interface IOrderDetailService {
    boolean createOrderDetail(OrderDetails orderDetails);
}
