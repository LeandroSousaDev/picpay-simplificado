package com.leandroSS.picpaySimplificado.services;

import com.leandroSS.picpaySimplificado.client.AuthorizationClient;
import com.leandroSS.picpaySimplificado.dto.TransationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AutorizationService {

    @Autowired
    private AuthorizationClient authorizationClient;

    public boolean isAuthorized() throws Exception {

        var response = authorizationClient.isAuthorized();

        if (response.getStatusCode() == HttpStatus.OK) {
            return true;
        }
        return false;
    }
}
