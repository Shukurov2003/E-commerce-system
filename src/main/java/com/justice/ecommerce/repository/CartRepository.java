package com.justice.ecommerce.repository;

import com.justice.ecommerce.entity.Cart;
import com.justice.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findAllByUserOrderByCreatedAtDesc(User user);
}
