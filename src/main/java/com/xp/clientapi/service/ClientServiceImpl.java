package com.xp.clientapi.service;

import com.xp.clientapi.entity.Client;
import com.xp.clientapi.exception.ResourceNotFoundException;
import com.xp.clientapi.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repo;

    public ClientServiceImpl(ClientRepository repo) {
        this.repo = repo;
    }

    @Override
    public Client create(Client cliente) {
        return repo.save(cliente);
    }

    @Override
    public List<Client> findAll() {
        return repo.findAll();
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public Client findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado: " + id));
    }

    @Override
    public List<Client> findByName(String nome) {
        return repo.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Client update(Long id, Client cliente) {
        Client existing = findById(id);
        existing.setNome(cliente.getNome());
        existing.setEmail(cliente.getEmail());
        existing.setTelefone(cliente.getTelefone());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.delete(findById(id));
    }
}
