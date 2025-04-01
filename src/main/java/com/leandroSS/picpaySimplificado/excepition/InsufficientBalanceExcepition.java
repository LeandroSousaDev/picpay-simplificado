package com.leandroSS.picpaySimplificado.excepition;

public class InsufficientBalanceExcepition extends RuntimeException{

    public InsufficientBalanceExcepition(String message) {
        super(message);
    }
}
