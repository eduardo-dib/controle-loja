package org.controleloja.service;

import jakarta.enterprise.context.*;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import org.controleloja.model.*;
import java.util.List;

@ApplicationScoped
public class VendaService {
    
	public List<VendaEntity> getAll() {
	    return VendaEntity.listAll(); 
	}
	
	public VendaEntity getById(Long id) {
		VendaEntity v = VendaEntity.findById(id);
		if(v == null) {
			throw new RuntimeException("Não foi possível encontrar produto com esse id");
		}
		return VendaEntity.findById(id);
	}
	
	public VendaEntity criar(Long clienteId, List<Long> produtoIds) {
	    ClienteEntity cliente = ClienteEntity.findById(clienteId);
	    if (cliente == null) {
	        throw new NotFoundException("Cliente não encontrado");
	    }

	    List<ProdutoEntity> produtos = ProdutoEntity.list("id in ?1", produtoIds);
	    if (produtos.size() != produtoIds.size()) {
	        throw new BadRequestException("Um ou mais produtos não existem");
	    }

	 
	    for (ProdutoEntity p : produtos) {
	        if (!p.disponivel) {
	            throw new BadRequestException("Produto '" + p.nome + "' não está disponível para venda.");
	        }
	    }

	    VendaEntity venda = new VendaEntity();
	    venda.cliente = cliente;
	    venda.produtos = produtos;
	    venda.valorTotal = produtos.stream()
	        .mapToInt(p -> p.preco.intValue())
	        .sum();

	    venda.persist();

	 
	    for (ProdutoEntity produto : produtos) {
	        produto.disponivel = false;
	        produto.persist();
	    }

	    return venda;
	}

	public VendaEntity atualizarVenda(Long id, VendaEntity venda) {
		VendaEntity v = VendaEntity.findById(id);
		if(v == null) {
			throw new RuntimeException("Não foi possível encontrar Venda com esse id");
		}
		
		v.cliente = venda.cliente;
		v.produtos = venda.produtos;
		v.valorTotal = venda.valorTotal;
		return v;
		
		
	}
	
	public VendaEntity deletarVenda(Long id) {
		VendaEntity v = VendaEntity.findById(id);
		if(v == null) {
			throw new RuntimeException("Não foi possível encontrar Venda com esse id");
		}
		v.delete();
		return v;
	}

	
	
}
