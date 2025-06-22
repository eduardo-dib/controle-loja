package org.controleloja.model;
import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.*;



@Entity
@Table(name = "cliente")
public class ClienteEntity extends PanacheEntity{
  
	@Column
	public String primeiroNome;
	
	@Column
	public String sobrenome;
	
	@Column
	public String usuarioInstagram;
	
}
