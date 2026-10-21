package com.fatec.lojinha.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    // BigDecimal é o tipo certo para dinheiro (evita erro de arredondamento do double)
    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    // Ex.: ABERTO, PAGO, ENVIADO, CANCELADO
    @Column(nullable = false, length = 20)
    private String status;

    // Relacionamento: muitos pedidos pertencem a um cliente.
    // No banco, isso cria a coluna "cliente_id" (chave estrangeira) na tabela pedido.
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Cliente cliente, BigDecimal valorTotal, String status) {
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataPedido = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
