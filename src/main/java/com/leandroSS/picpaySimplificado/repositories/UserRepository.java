package com.leandroSS.picpaySimplificado.repositories;

import com.leandroSS.picpaySimplificado.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByDocument(String document);

    Optional<UserEntity> findUserById(Long id);
}
