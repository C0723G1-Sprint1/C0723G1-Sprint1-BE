package com.example.medical_supplies.service.order;

import com.example.medical_supplies.model.cart.OrderDetails;
import com.example.medical_supplies.model.cart.Orders;
import com.example.medical_supplies.repository.order.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Override
    public boolean createOrderDetail(OrderDetails orderDetails) {
        try {
            orderDetailRepository.createOrderDetail(orderDetails);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
