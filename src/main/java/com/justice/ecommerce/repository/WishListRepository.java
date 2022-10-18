package com.justice.ecommerce.repository;

import com.justice.ecommerce.entity.Product;
import com.justice.ecommerce.entity.User;
import com.justice.ecommerce.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

    List<WishList> findAllByUser(User user);


}
