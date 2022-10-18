package com.justice.ecommerce.service;

import com.justice.ecommerce.dto.user.SignInDTO;
import com.justice.ecommerce.dto.user.SignUpDTO;
import com.justice.ecommerce.model.ResponseDTO;
import com.justice.ecommerce.model.SignInResponseDTO;

public interface UserService {

    ResponseDTO signUp(SignUpDTO signUpDTO);
    SignInResponseDTO signIn(SignInDTO signInDTO);

}
