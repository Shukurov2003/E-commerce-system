package com.justice.ecommerce.repository;

import com.justice.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    void deleteProductByCategoryId(Long id);
}
