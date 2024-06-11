package com.matiasdev.crud.client.services;

import com.matiasdev.crud.client.dto.ClientsDto;

import com.matiasdev.crud.client.entities.Client;
import com.matiasdev.crud.client.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientsServices {


    @Autowired
    private ClientsRepository repository;

    // get client/id
    @Transactional(readOnly = true)
    public ClientsDto findById(Long id){
        Client client = repository.findById(id).get();
        ClientsDto clientsDto = new ClientsDto(client);
        return clientsDto;
    }
    // get all client /client
    @Transactional(readOnly = true)
    public Page<ClientsDto> findAll(Pageable pegeable){
        Page<Client> result = repository.findAll(pegeable);
        Page<ClientsDto> clientsDtosList =  result.map((x-> new ClientsDto(x)));
        return clientsDtosList;
    }
   // add new client post
    @Transactional
    public ClientsDto post (ClientsDto dto){
        Client entity = new Client();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setSalary(dto.getSalary());
        entity.setBirthDate(dto.getBirthDate());

        entity = repository.save(entity);
        return new ClientsDto(entity);
    }
    // put by id
    @Transactional
    public ClientsDto  update(Long id, ClientsDto dto){
        Client entity = repository.getReferenceById(id);
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setSalary(dto.getSalary());
        entity.setBirthDate(dto.getBirthDate());

        entity = repository.save(entity);
        return new ClientsDto(entity);
    }

    //delete by id
    @Transactional
    public  void  deletebyid(Long id ){
        repository.deleteById(id);
    }









}
