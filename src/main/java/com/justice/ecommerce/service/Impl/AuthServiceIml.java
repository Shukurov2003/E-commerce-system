package com.justice.ecommerce.service.Impl;

import com.justice.ecommerce.entity.AuthToken;
import com.justice.ecommerce.entity.User;
import com.justice.ecommerce.exeptions.AuthenticationFailedException;
import com.justice.ecommerce.repository.AuthTokenRepository;
import com.justice.ecommerce.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceIml implements AuthService {

    private final AuthTokenRepository authTokenRepository;

    public AuthServiceIml(AuthTokenRepository authTokenRepository) {
        this.authTokenRepository = authTokenRepository;
    }

    @Override
    public void saveConfirmationToken(AuthToken authToken) {
        authTokenRepository.save(authToken);
    }



    @Override
    public AuthToken getAuthTokenByUser(User user) {
        return authTokenRepository.findByUser(user);
    }

    @Override
    public User getUserByToken(String token) {
        final AuthToken authToken = authTokenRepository.findByToken(token);
        if(Objects.isNull(authToken)){
            throw  null;
        }

        return authToken.getUser();
    }

    @Override
    public void authenticate(String token) {

        if(Objects.isNull(token)){
            throw new AuthenticationFailedException("token is not present");
        }

        if (Objects.isNull(getUserByToken(token))){
            throw  new AuthenticationFailedException("token is not valid");
        }
    }


}
