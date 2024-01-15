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

@Repository
public interface IProductRepository extends JpaRepository<Products, Long> {

    @Query(value = "select * from products", nativeQuery = true)
    Page<Products> findAllProduct(Pageable pageable);

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
}
