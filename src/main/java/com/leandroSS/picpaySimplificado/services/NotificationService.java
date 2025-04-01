package com.leandroSS.picpaySimplificado.services;

import com.leandroSS.picpaySimplificado.client.NotficationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotficationClient notficationClient;

    public void sendNotification() {
        notficationClient.sendNotification();
    }


}
