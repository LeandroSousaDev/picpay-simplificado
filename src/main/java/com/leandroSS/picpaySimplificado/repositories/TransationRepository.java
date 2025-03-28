package com.leandroSS.picpaySimplificado.repositories;

import com.leandroSS.picpaySimplificado.domain.transation.TransationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransationRepository extends JpaRepository<TransationEntity, Long> {
}
