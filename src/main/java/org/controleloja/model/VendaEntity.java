package org.controleloja.model;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

@Entity
@Table(name = "Vendas")
public class VendaEntity extends PanacheEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    public ClienteEntity cliente;

    @ManyToMany
    @JoinTable(
        name = "venda_produto",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    public List<ProdutoEntity> produtos;

    @Column(nullable = false)
    public int valorTotal;
}
