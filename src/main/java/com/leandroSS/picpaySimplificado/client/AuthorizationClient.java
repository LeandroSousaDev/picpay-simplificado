package com.leandroSS.picpaySimplificado.client;

import com.leandroSS.picpaySimplificado.dto.AuthorizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "AuthorizationClient",
        url = "https://util.devi.tools/api/v2/authorize"
)
public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationDTO> isAuthorized();
}
