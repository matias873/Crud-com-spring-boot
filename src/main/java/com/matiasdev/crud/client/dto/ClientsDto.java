package com.matiasdev.crud.client.dto;


import com.matiasdev.crud.client.entities.Client;

import java.time.LocalDate;

public class ClientsDto {


    private Long id;
    private  String nome ;
    private  String cpf;
    private Double salary;
    private LocalDate birthDate;

    public ClientsDto(Long id, String nome, String cpf, Double salary, LocalDate birthDate) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salary = salary;
        this.birthDate = birthDate;
    }
    public ClientsDto (Client entidade){
        id = entidade.getId();
        nome = entidade.getNome();
        cpf = entidade.getCpf();
        salary = entidade.getSalary();
        birthDate = entidade.getBirthDate();
    }




    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
