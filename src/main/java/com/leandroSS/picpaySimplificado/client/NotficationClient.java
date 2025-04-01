package com.leandroSS.picpaySimplificado.client;

import com.leandroSS.picpaySimplificado.dto.TransationDTO;
import com.leandroSS.picpaySimplificado.entities.transation.TransationEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "NotficationClient",
        url = "https://util.devi.tools/api/v1/notify"
)
public interface NotficationClient {
    @PostMapping
    ResponseEntity<Void> sendNotification();
}
