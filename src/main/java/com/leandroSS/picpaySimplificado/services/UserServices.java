package com.leandroSS.picpaySimplificado.services;

import com.leandroSS.picpaySimplificado.entities.user.UserEntity;
import com.leandroSS.picpaySimplificado.entities.user.UserType;
import com.leandroSS.picpaySimplificado.dto.UserDTO;
import com.leandroSS.picpaySimplificado.excepition.InsufficientBalanceExcepition;
import com.leandroSS.picpaySimplificado.excepition.NotFoundUserException;
import com.leandroSS.picpaySimplificado.excepition.UnauthorizedUserExcepition;
import com.leandroSS.picpaySimplificado.excepition.UserDataAlreadyExistsException;
import com.leandroSS.picpaySimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void validateTransation(UserEntity sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new UnauthorizedUserExcepition("Usuario não altorizado a fazer transferencias");
        }

        if (sender.getBalace().compareTo(amount) < 0) {
            throw new InsufficientBalanceExcepition("Saldo insuficiente");
        }
    }

    public UserEntity findUser(Long id) throws Exception {
       return this.userRepository.findById(id)
               .orElseThrow(() -> new NotFoundUserException("usuario não encontrado"));
    }

    public void saveUser(UserEntity user) {
        this.userRepository.save(user);
    }

    public UserEntity  createUser(UserDTO userDTO) {

        var userExists = this.userRepository.findByDocumentOrEmail(userDTO.document(), userDTO.email());

        if (userExists.isPresent()) {
            throw new UserDataAlreadyExistsException("Email ou documento ja existe no banco de dados");
        }

        UserEntity newUser = new UserEntity(userDTO);
        this.userRepository.save(newUser);
        return newUser;
    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }
}









