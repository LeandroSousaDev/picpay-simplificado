package com.leandroSS.picpaySimplificado.entities.user;

import com.leandroSS.picpaySimplificado.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balace;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserEntity(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.email = data.email();
        this.document = data.document();
        this.balace = data.balance();
        this.password = data.password();
        this.userType = data.userType();
    }
}
