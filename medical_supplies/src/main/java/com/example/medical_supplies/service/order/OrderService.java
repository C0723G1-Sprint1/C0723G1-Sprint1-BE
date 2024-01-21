package com.example.medical_supplies.service.order;

import com.example.medical_supplies.model.cart.Orders;
import com.example.medical_supplies.repository.order.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public Orders createOrder(Orders orders) {
        try {
           Orders orderNew =orderRepository.save(orders);
            return orderNew;
        }catch (Exception e){
            return null;
        }
    }
}
