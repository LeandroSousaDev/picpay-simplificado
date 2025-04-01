package com.leandroSS.picpaySimplificado.services;

import com.leandroSS.picpaySimplificado.entities.transation.TransationEntity;
import com.leandroSS.picpaySimplificado.entities.user.UserEntity;
import com.leandroSS.picpaySimplificado.dto.TransationDTO;
import com.leandroSS.picpaySimplificado.repositories.TransationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class TransationServices {

    @Autowired
    private TransationRepository transationRepository;

    @Autowired
    private UserServices userServices;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notficationService;

    @Autowired
    private AutorizationService autorizationService;

    public TransationEntity createTransation(TransationDTO transationDTO) throws Exception {
        UserEntity sender = this.userServices.findUser(transationDTO.senderId());
        UserEntity receiver = this.userServices.findUser(transationDTO.receiverId());

        this.userServices.validateTransation(sender, transationDTO.value());

        if (!autorizationService.isAuthorized()) {
            throw new Exception("transação não autorizada");
        }

        TransationEntity newTransation = new TransationEntity();
        newTransation.setAmount(transationDTO.value());
        newTransation.setSender(sender);
        newTransation.setReceiver(receiver);
        newTransation.setTimestamp(LocalDate.now());

        sender.setBalace(sender.getBalace().subtract(transationDTO.value()));
        receiver.setBalace(receiver.getBalace().add(transationDTO.value()));

        this.transationRepository.save(newTransation);
        this.userServices.saveUser(sender);
        this.userServices.saveUser(receiver);

//        this.notficationService.sendNotification();
//        this.notficationService.sendNotification();

        return newTransation;
    }

}








