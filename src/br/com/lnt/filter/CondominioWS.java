package br.com.lnt.filter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lnt.model.util.bloco;
import br.com.lnt.model.util.condominio;
import br.com.lnt.service.CondominioService;

@RequestScoped
@Path("/condominio")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class CondominioWS {

	@Inject
	CondominioService service;

	@GET
	@Path("/listaCondominio")
	@Produces(MediaType.APPLICATION_JSON)
	public List<condominio> listarCondominio() {
		return this.service.listarCondominios();
	}

	@GET
	@Path("/listaBloco/{condominio}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<bloco> listarBloco(@PathParam("condominio") int condominio) {
		return this.service.listarBlocos(condominio);
	}
}
