package com.justice.ecommerce.controller;

import com.justice.ecommerce.dto.user.SignInDTO;
import com.justice.ecommerce.dto.user.SignUpDTO;
import com.justice.ecommerce.model.ResponseDTO;
import com.justice.ecommerce.model.SignInResponseDTO;
import com.justice.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseDTO signup(@RequestBody SignUpDTO userDTO){
        return userService.signUp(userDTO) ;
    }


    @PostMapping("/signin")
    public SignInResponseDTO signIn(@RequestBody SignInDTO signInDTO){
        return userService.signIn(signInDTO);
    }
}
