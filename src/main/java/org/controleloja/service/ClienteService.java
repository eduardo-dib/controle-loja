package org.controleloja.service;

import jakarta.enterprise.context.*;
import org.controleloja.model.ClienteEntity;
import java.util.List;


@ApplicationScoped
public class ClienteService {
    public List<ClienteEntity> getAllClientes(){
    	return ClienteEntity.listAll();
    }
    
    public ClienteEntity getById(Long id) {
    	ClienteEntity c = ClienteEntity.findById(id);
    	if(c == null) {
    		throw new RuntimeException("Não foi possível encontrar cliente com esse ID");
    	}
    	return c;
    }
    
    public ClienteEntity criar(ClienteEntity c) {
    	 c.persist();
    	 return c;
    }
    
    public ClienteEntity atualizar(Long id, ClienteEntity c) {
    	ClienteEntity cliente = ClienteEntity.findById(id);
    	if(cliente == null) {
    		throw new RuntimeException("Não foi possível encontrar cliente com esse ID");
    	}
    	cliente.primeiroNome = c.primeiroNome;
    	cliente.sobrenome = c.sobrenome;
    	cliente.usuarioInstagram = c.usuarioInstagram;
    	
    	return c;
    }
    
    public ClienteEntity deletar(Long id) {
    	ClienteEntity c = ClienteEntity.findById(id);
    	if(c == null) {
    		throw new RuntimeException("Não foi possível encontrar cliente com esse ID");
    	}
    	c.delete();
    	return c;
    }
    
    
}
