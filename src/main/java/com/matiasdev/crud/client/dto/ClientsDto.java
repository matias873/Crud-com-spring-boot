package com.matiasdev.crud.client.dto;


import com.matiasdev.crud.client.entities.Client;
import jakarta.validation.constraints.*;


import java.time.LocalDate;

public class ClientsDto {


    private Long id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    private  String nome ;

    @NotBlank(message = "O CPF não pode ser vazio")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos")
    private  String cpf;

    @NotNull(message = "O salário não pode ser nulo")
    @Positive(message = "O salário deve ser positivo")
    private Double salary;

    @NotNull(message = "A data de nascimento não pode ser nula")
    @PastOrPresent(message = "A data de nascimento deve ser no passado")
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
