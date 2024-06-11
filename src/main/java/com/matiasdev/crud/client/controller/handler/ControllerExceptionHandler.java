package com.matiasdev.crud.client.controller.handler;

import com.matiasdev.crud.client.dto.CustomErro;
import com.matiasdev.crud.client.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.awt.event.WindowStateListener;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErro> handleresouceNotFounnd
            (ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErro err = new CustomErro(status.value(), Instant.now(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }


}
