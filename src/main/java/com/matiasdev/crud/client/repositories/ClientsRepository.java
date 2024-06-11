package com.matiasdev.crud.client.repositories;

import com.matiasdev.crud.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, Long> {
}
