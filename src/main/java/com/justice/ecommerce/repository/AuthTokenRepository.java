package com.justice.ecommerce.repository;


import com.justice.ecommerce.entity.AuthToken;
import com.justice.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken,Long> {

    AuthToken findByUser(User user);
    AuthToken findByToken(String token);
}
