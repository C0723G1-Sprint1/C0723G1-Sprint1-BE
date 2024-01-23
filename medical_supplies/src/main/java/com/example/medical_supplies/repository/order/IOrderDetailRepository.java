package com.example.medical_supplies.repository.order;

import com.example.medical_supplies.model.auth.Customer;
import com.example.medical_supplies.model.cart.OrderDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderDetailRepository extends JpaRepository<OrderDetails,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into order_details (price,quantity,id_order,id_product) " +
            "values (:#{#orderDetail.price}, :#{#orderDetail.quantity}, :#{#orderDetail.order.id}, :#{#orderDetail.products.id})",nativeQuery = true)
    void createOrderDetail(@Param("orderDetail") OrderDetails orderDetails);
}
