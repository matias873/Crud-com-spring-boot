package com.matiasdev.crud.client.repositories;

import com.matiasdev.crud.client.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientsRepository extends JpaRepository<Client, Long> {

    Page<Client> findAllByAtivoTrue(Pageable paginacao);

    Optional<Client> findAllByAtivoTrue();



}
