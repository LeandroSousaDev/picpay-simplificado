package com.leandroSS.picpaySimplificado.controllers;

import com.leandroSS.picpaySimplificado.entities.transation.TransationEntity;
import com.leandroSS.picpaySimplificado.dto.TransationDTO;
import com.leandroSS.picpaySimplificado.services.TransationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transations")
public class TransationController {

    @Autowired
    private TransationServices transationServices;

    @PostMapping("/")
    public ResponseEntity<TransationEntity>  createTransation(@RequestBody TransationDTO transationDTO)
            throws Exception {
        var newTransation = this.transationServices.createTransation(transationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransation);
    }





}
