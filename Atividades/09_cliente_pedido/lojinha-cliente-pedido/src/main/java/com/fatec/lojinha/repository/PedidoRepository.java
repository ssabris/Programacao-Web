package com.fatec.lojinha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.lojinha.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // SELECT * FROM pedido WHERE cliente_id = ?
    List<Pedido> findByClienteId(Long clienteId);

    // SELECT * FROM pedido WHERE status = ?
    List<Pedido> findByStatus(String status);
}
