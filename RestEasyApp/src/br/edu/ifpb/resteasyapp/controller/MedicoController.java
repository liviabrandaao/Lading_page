package br.edu.ifpb.resteasyapp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.resteasyapp.dao.MedicoDAO;
import br.edu.ifpb.resteasyapp.entidade.Medico;

@Path("medico")
public class MedicoController {

	/**
	 * Cadastra o medico no sistema.
	 * 
	 * @param medico
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/inserir")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Medico medico) {
		
		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		//TODO: Regra de neg�cio e manipula��o de dados nesse ponto. As informa��os devem ser associadas
		// nesse ponto ao biuld (response).
		
		try {
			
			int crm = MedicoDAO.getInstance().insert(medico);
			
			medico.setCrm(crm);
			
			builder.status(Response.Status.OK).entity(medico);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		// Resposta.
		return builder.build();
	}
	
	/**
	 * Retorna todos os medicos cadastrados.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Medico> getAll() {
		
		// Retorno em formato de lista.
		// Desse modo o response sempre conter� o c�digo de resposta OK.
		List<Medico> medicos = new ArrayList<Medico>();
		
		try {
			
			//TODO: Regra de neg�cio e manipula��o de dados nesse ponto.
			medicos = MedicoDAO.getInstance().getAll();
		
		} catch (SQLException e) {
			
			// TODO: Tratar a exce��o.
		}
		
		// Ser� retornado ao cliente um conjunto de alunos no formato de Json.
		return medicos;
	}
	
	/**
	 * Recupera o alunos cadastrado no sistema atrav�s do seu id.
	 * 
	 * @param idAluno
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getMedicoByCRM(@PathParam("crm") int crm) {
		
		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			// Regra de neg�cio e manipula��o de dados nesse ponto.
			Medico medico = MedicoDAO.getInstance().getById(crm); 
			
			if (medico != null) {
				
				// As informa��os associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(medico);
				
			} else {
				
				// Conte�do n�o encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
}
