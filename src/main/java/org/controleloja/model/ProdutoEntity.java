package org.controleloja.model;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.*;
import jakarta.ws.rs.*;

@Entity
public class ProdutoEntity extends PanacheEntity{
  @Column(nullable = false)
  public String nome;
  
  @Column(nullable = false)
  public String descricao;
  
  @Column(nullable = false)
  public Double preco;
  
  @Column(nullable = false)
  public String imagemUrl;
  
  
  
  
}
