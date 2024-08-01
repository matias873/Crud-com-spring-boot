package com.matiasdev.crud.client.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome ;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private  String cpf;
    private Double salary;
    private LocalDate birthDate;
    private  Boolean ativo;

    public Client(){
    }

    public Client(Long id, String nome, String email, String cpf, Double salary, LocalDate birthDate) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.salary = salary;
        this.birthDate = birthDate;
        this.ativo = Boolean.TRUE;
    }
    public void excluir() {
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client clients = (Client) o;
        return Objects.equals(id, clients.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


