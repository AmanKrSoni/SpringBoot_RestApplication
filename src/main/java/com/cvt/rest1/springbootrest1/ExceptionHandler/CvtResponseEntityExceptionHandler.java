package com.cvt.rest1.springbootrest1.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CvtResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    //Method to handle All Exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){

        ExceptionResponseFormat exceptionResponseFormat=new ExceptionResponseFormat(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponseFormat, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Custom UserNotFound Exception
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest request){
        ExceptionResponseFormat exceptionResponseFormat =
        new ExceptionResponseFormat(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponseFormat,HttpStatus.NOT_FOUND);
    }
}
