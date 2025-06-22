package org.controleloja.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import org.controleloja.service.*;
import org.controleloja.model.*;
import java.util.List;
import jakarta.inject.Inject;


@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {
	@Inject
	ClienteService clienteService;
	
	@GET
	public List<ClienteEntity> getAll(){
		return clienteService.getAllClientes();
	}
	
	@GET
	@Path("/{id}")
	public ClienteEntity getById(@PathParam("id") Long id) {
		return clienteService.getById(id);
	}
	
	@POST
	@Transactional
	public ClienteEntity criar(ClienteEntity c) {
		return clienteService.criar(c);
	}
	
	@PUT
	@Path("/atualizar/{id}")
	@Transactional
	public ClienteEntity atualizar(@PathParam("id") Long id, ClienteEntity c) {
		return clienteService.atualizar(id, c);
	}
	
	@DELETE
	@Path("/deletar/{id}")
	@Transactional
	public ClienteEntity deletar(@PathParam("id") Long id) {
		return clienteService.deletar(id);
	}
}
