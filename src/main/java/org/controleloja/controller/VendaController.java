package org.controleloja.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import org.controleloja.service.*;
import org.controleloja.model.*;
import java.util.List;
import jakarta.inject.Inject;
import org.controleloja.dto.*;


@Path("/vendas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendaController {
	
	@Inject
	VendaService vendaService;
	
	@GET
	public List<VendaEntity> getAll(){
		return vendaService.getAll();
	}
	
	
	@GET
	@Path("/{id}")
	public VendaEntity getById(@PathParam("id") Long id) {
		return vendaService.getById(id);
	}
	
	@POST
	@Transactional
	public VendaEntity criar(VendaRequestDTO request) {
	    return vendaService.criar(request.clienteId, request.produtoIds);
	}
	
	@PUT
	@Transactional
	@Path("/atualizar/{id}")
	public VendaEntity atualizar(@PathParam("id") Long id, VendaEntity venda) {
		return vendaService.atualizarVenda(id, venda);
	}
	
	@DELETE
	@Transactional
	@Path("/deletar/{id}")
	public VendaEntity deletar(@PathParam("id") Long id) {
		return vendaService.deletarVenda(id);
	}
}
