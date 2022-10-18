package com.justice.ecommerce.service;

import com.justice.ecommerce.entity.AuthToken;
import com.justice.ecommerce.entity.User;

public interface AuthService {
    void saveConfirmationToken(AuthToken authToken);

    AuthToken getAuthTokenByUser(User user);

    User getUserByToken(String token);

    void authenticate(String token);

}
