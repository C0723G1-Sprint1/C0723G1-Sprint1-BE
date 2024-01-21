package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.dto.product.ProductDTO;
import com.example.medical_supplies.model.product.Products;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Products,Integer> {


    /**
     * Author: AnHN.
     * This is the method to get the product list and search by name
     * return ResponseEntity and product or null
     */

    @Query(value = "select p.*,ty.name_type_product,pr.name_productions from products p join type_product ty on p.id_type_product = ty.id " +
            "join productions pr on p.id_production = pr.id where p.name like :nameSearch and ty.name_type_product like :typeProduct " +
            "and pr.name_productions like :nameProductions ",nativeQuery = true)
    Page<Products> findAllProduct(Pageable pageable, @Param("nameSearch") String nameSearch, @Param("typeProduct") String typeProduct, @Param("nameProductions") String nameProductions );


    //HAI
    @Query(value = "select * from products", nativeQuery = true)
    Page<Products> getAllProduct(Pageable pageable);

    @Query(value = "select * from products where products.id=:id", nativeQuery = true)
    Products getProductById(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO products(name, price, supplier, quantity, avatar_one, avatar_two, main_avatar, ingredient, id_production, id_type_product)" +
            " VALUES (:#{#productDTO.name}, :#{#productDTO.price}, :#{#productDTO.supplier}, :#{#productDTO.quantity}," +
            " :#{#productDTO.avatarOne}, :#{#productDTO.avatarTwo}, :#{#productDTO.mainAvatar}, :#{#productDTO.ingredient}," +
            " :#{#productDTO.productions}, :#{#productDTO.typeProduct})", nativeQuery = true)
    void createProduct(@Param("productDTO") ProductDTO productDTO);



    @Transactional
    @Modifying
    @Query(value = "UPDATE products " +
            "SET name = :#{#productDTO.name}, price = :#{#productDTO.price}, " +
            "supplier = :#{#productDTO.supplier}, quantity = :#{#productDTO.quantity}, " +
            "avatar_one = :#{#productDTO.avatarOne}, avatar_two = :#{#productDTO.avatarTwo}, " +
            "main_avatar = :#{#productDTO.mainAvatar}, ingredient = :#{#productDTO.ingredient}, " +
            "id_production = :#{#productDTO.productions}, id_type_product = :#{#productDTO.typeProduct} " +
            "WHERE id = :#{#productDTO.id} ", nativeQuery = true)
    void updateProduct(@Param("productDTO") ProductDTO productDTO);


    @Query(value = "select * products",nativeQuery = true)
    List<Products> getListProduct();
}
