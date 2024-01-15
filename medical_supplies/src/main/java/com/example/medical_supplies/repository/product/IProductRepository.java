package com.example.medical_supplies.repository.product;

import com.example.medical_supplies.model.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
}
