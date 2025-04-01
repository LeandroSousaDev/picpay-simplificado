package com.leandroSS.picpaySimplificado.excepition;

import com.leandroSS.picpaySimplificado.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepitionHandler {

    @ExceptionHandler(UserDataAlreadyExistsException.class)
    ResponseEntity<ErrorMessage> userDataAlreadyExistsException(UserDataAlreadyExistsException exception) {
        ErrorMessage threartResponse = new ErrorMessage(exception.getMessage(), "422");
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(threartResponse);
    }

    @ExceptionHandler(NotFoundUserException.class)
    ResponseEntity<ErrorMessage> notFoundUserException(NotFoundUserException exception) {
        ErrorMessage threartResponse = new ErrorMessage(exception.getMessage(),"404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threartResponse);
    }

    @ExceptionHandler(InsufficientBalanceExcepition.class)
    ResponseEntity<ErrorMessage> insufficientBalanceExcepition(InsufficientBalanceExcepition excepition) {
        ErrorMessage threartResponse = new ErrorMessage(excepition.getMessage(),"400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threartResponse);
    }

    @ExceptionHandler(UnauthorizedUserExcepition.class)
    ResponseEntity<ErrorMessage> unauthorizedUserExcepition(UnauthorizedUserExcepition excepition) {
        ErrorMessage threartResponse = new ErrorMessage(excepition.getMessage(),"400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threartResponse);
    }



}
