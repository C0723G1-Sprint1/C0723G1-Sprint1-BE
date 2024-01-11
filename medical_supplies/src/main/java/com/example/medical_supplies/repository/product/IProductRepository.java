package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Products,Long> {

    @Query(value = "select * from products",nativeQuery = true)
    Page<Products> findAllProduct(Pageable pageable);

    @Query(value = "select * from products where products.id=:id", nativeQuery = true)
    Products getProductById(@Param("id") Long id);

    @Query(value = "insert into products(name,price,supplier,quantity,avatar_one,avatar_two,main_avatar,ingredient,id_production,id_type_product)" +
            "values (product.name,product.price,product.supplier,product.quantity,product.avatar_one,product.avatar_two,product.main_avatar,product.ingredient," +
            "product.productions,product.typeProduct)",nativeQuery = true)
    void createProduct(@Param("product") Products products);
}
