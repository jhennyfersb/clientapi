package com.xp.clientapi.repository;

import com.xp.clientapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNomeContainingIgnoreCase(String nome);
}