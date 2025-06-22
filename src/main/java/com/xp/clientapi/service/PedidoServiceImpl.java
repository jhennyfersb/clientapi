package com.xp.clientapi.service;

import com.xp.clientapi.entity.Pedido;
import com.xp.clientapi.exception.ResourceNotFoundException;
import com.xp.clientapi.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repo;

    public PedidoServiceImpl(PedidoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Pedido create(Pedido pedido) {
        return repo.save(pedido);
    }

    @Override
    public List<Pedido> findAll() {
        return repo.findAll();
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public Pedido findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado: " + id));
    }

    @Override
    public List<Pedido> findByClienteId(Long clienteId) {
        return repo.findByClienteId(clienteId);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        Pedido existing = findById(id);
        existing.setClienteId(pedido.getClienteId());
        existing.setTotal(pedido.getTotal());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.delete(findById(id));
    }
}
