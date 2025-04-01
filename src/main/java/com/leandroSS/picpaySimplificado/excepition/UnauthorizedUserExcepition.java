package com.leandroSS.picpaySimplificado.excepition;

public class UnauthorizedUserExcepition extends RuntimeException{

    public UnauthorizedUserExcepition(String message) {
        super(message);
    }
}
