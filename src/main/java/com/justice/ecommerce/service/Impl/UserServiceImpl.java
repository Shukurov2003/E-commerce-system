package com.justice.ecommerce.service.Impl;

import com.justice.ecommerce.dto.user.SignInDTO;
import com.justice.ecommerce.dto.user.SignUpDTO;
import com.justice.ecommerce.entity.AuthToken;
import com.justice.ecommerce.entity.User;
import com.justice.ecommerce.exeptions.AuthenticationFailedException;
import com.justice.ecommerce.exeptions.CustomException;
import com.justice.ecommerce.model.ResponseDTO;
import com.justice.ecommerce.model.SignInResponseDTO;
import com.justice.ecommerce.repository.UserRepository;
import com.justice.ecommerce.service.AuthService;
import com.justice.ecommerce.service.UserService;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthService authService;

    public UserServiceImpl(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @Override
    public ResponseDTO signUp(SignUpDTO signUpDTO) {
        User user = userRepository.findByEmail(signUpDTO.getEmail());
        if(Objects.nonNull(user)){
            throw new CustomException("This user has already existed");
        }


        String encryptedPassword = signUpDTO.getPassword();
        try{
            encryptedPassword = hashPassword(signUpDTO.getPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }

        user = new User(
                signUpDTO.getFirstName(),
                signUpDTO.getLastName(),
                signUpDTO.getEmail(),
                encryptedPassword
        );

        userRepository.save(user);
        final AuthToken authToken = new AuthToken(user);
        authService.saveConfirmationToken(authToken);

        return ResponseDTO.ok("dummy response");
    }



    @Override
    public SignInResponseDTO signIn(SignInDTO signInDTO) {
        User user = userRepository.findByEmail(signInDTO.getEmail());
        if(Objects.isNull(user)){
            throw new AuthenticationFailedException("this user is not present");
        }


        try {
            if (!user.getPassword().equals(hashPassword(signInDTO.getPassword()))){
                throw new AuthenticationFailedException("this password is not valid");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        AuthToken Authtoken = authService.getAuthTokenByUser(user);

        if(Objects.isNull(Authtoken)){
            throw new CustomException("token is not present");
        }

        String token = Authtoken.getToken();
        return SignInResponseDTO.ok(token);
    }


    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();;
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }
}
