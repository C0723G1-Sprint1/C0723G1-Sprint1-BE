package com.example.medical_supplies.dto.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer idCustomer;
    private String [] listProduct;

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String[] getListProduct() {
        return listProduct;
    }

    public void setListProduct(String[] listProduct) {
        this.listProduct = listProduct;
    }
}
