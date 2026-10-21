package com.fatec.lojinha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.lojinha.model.Cliente;

// O JpaRepository já traz pronto: save, findById, findAll, deleteById, count...
// <Cliente, Long> = entidade que ele gerencia + tipo do id
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // O Spring cria a consulta sozinho a partir do nome do método:
    // SELECT * FROM cliente WHERE email = ?
    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findByCpf(String cpf);
}
