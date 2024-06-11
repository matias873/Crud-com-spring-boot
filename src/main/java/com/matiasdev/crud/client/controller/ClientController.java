package com.matiasdev.crud.client.controller;


import com.matiasdev.crud.client.dto.ClientsDto;
import com.matiasdev.crud.client.services.ClientsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientsServices services;

    @GetMapping(value = "/{id}")
    public ResponseEntity< ClientsDto> findById (@PathVariable Long id){
        ClientsDto  dto =services.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity< Page<ClientsDto> >findAll (Pageable pegeable){
        Page<ClientsDto> dtos = services.findAll(pegeable);
         return ResponseEntity.ok(dtos);

    }


    @PostMapping
    public ResponseEntity<ClientsDto> post(@RequestBody ClientsDto dto){
        dto = services.post(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id]")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientsDto> update(@RequestBody ClientsDto dto, @PathVariable Long id ){
        dto = services.update(id, dto);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientsDto> delete (@PathVariable Long id){
        services.deletebyid(id);
        return ResponseEntity.noContent().build();
    }






}
