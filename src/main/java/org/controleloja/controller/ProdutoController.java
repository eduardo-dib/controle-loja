package org.controleloja.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import org.controleloja.service.*;
import org.controleloja.model.*;
import java.util.List;
import jakarta.inject.Inject;


@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {
	
	@Inject
	ProdutoService produtoService;
   
	@GET
	public List<ProdutoEntity> listarTodos(){
		return produtoService.listarTodosOsProdutos();
	}
	
	@GET
	@Path("/{id}")
	public ProdutoEntity getById(@PathParam("id") Long id) {
		return produtoService.getById(id);
	}
	
	@POST
	@Transactional
	public ProdutoEntity cadastrar(ProdutoEntity produto) {
		return produtoService.cadastrarProduto(produto);
	}
	
	@PUT
	@Path("/atualizar/{id}")
	@Transactional
	public ProdutoEntity atualizar(@PathParam("id") Long id, ProdutoEntity produtoAtualizado) {
		return produtoService.atualizarProduto(id, produtoAtualizado);
	}
	
	@DELETE
	@Path("/deletar/{id}")
	@Transactional
	public ProdutoEntity deletar(@PathParam("id") Long id) {
		return produtoService.deletarProduto(id);
	}
}
