package com.leandroSS.picpaySimplificado.excepition;

public class UserDataAlreadyExistsException extends RuntimeException{

   public UserDataAlreadyExistsException(String message) {
       super(message);
   }

}
