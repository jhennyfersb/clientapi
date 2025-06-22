package com.xp.clientapi.service;

import com.xp.clientapi.entity.Client;

import java.util.List;

public interface ClientService {

    Client create(Client cliente);

    List<Client> findAll();

    long count();

    Client findById(Long id);

    List<Client> findByName(String nome);

    Client update(Long id, Client cliente);

    void delete(Long id);
}
