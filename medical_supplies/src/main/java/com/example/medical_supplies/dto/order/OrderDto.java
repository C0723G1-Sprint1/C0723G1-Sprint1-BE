package com.example.medical_supplies.dto.order;

import com.example.medical_supplies.model.auth.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer idCustomer;
    private List<OrderDetailDto> list;

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<OrderDetailDto> getList() {
        return list;
    }

    public void setList(List<OrderDetailDto> list) {
        this.list = list;
    }
}
