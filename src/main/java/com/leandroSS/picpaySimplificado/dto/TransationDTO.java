package com.leandroSS.picpaySimplificado.dto;

import java.math.BigDecimal;

public record TransationDTO(BigDecimal value, Long senderId, Long receiverId) {
}
