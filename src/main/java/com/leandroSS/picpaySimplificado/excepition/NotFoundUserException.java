package com.leandroSS.picpaySimplificado.excepition;

public class NotFoundUserException extends RuntimeException{

    public NotFoundUserException(String message) {
        super(message);
    }
}
