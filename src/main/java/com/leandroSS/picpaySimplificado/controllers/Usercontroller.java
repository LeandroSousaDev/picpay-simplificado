package com.leandroSS.picpaySimplificado.controllers;

import com.leandroSS.picpaySimplificado.entities.user.UserEntity;
import com.leandroSS.picpaySimplificado.dto.UserDTO;
import com.leandroSS.picpaySimplificado.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private UserServices userServices;

    @PostMapping("/")
    public ResponseEntity<UserEntity> creteUser(@RequestBody UserDTO userDTO) {
        var newUser = this.userServices.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> listUsers() {
        var users = userServices.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}





