package com.xp.clientapi.service;

import com.xp.clientapi.entity.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido create(Pedido pedido);

    List<Pedido> findAll();

    long count();

    Pedido findById(Long id);

    List<Pedido> findByClienteId(Long clienteId);

    Pedido update(Long id, Pedido pedido);

    void delete(Long id);
}
