package com.leandroSS.picpaySimplificado.dto;

import com.leandroSS.picpaySimplificado.entities.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName,
                      String lastName,
                      String email,
                      String document,
                      BigDecimal balance,
                      String password,
                      UserType userType) {
}
