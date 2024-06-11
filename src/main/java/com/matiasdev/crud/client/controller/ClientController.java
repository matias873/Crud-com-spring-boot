package com.matiasdev.crud.client.controller;


import com.matiasdev.crud.client.dto.ClientsDto;
import com.matiasdev.crud.client.services.ClientsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientsServices services;

    @GetMapping(value = "/{id}")
    public ClientsDto findById (@PathVariable Long id){
        ClientsDto  dto =services.findById(id);
        return dto;
    }

    @GetMapping
    public Page<ClientsDto> findAll (Pageable pegeable){
        return services.findAll(pegeable);
    }




}
