package com.leandroSS.picpaySimplificado.repositories;

import com.leandroSS.picpaySimplificado.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByDocumentOrEmail(String document, String email);

    Optional<UserEntity> findUserById(Long id);
}
