package br.com.cmdev.jaxrsejersey.resource;

import br.com.cmdev.jaxrsejersey.dao.ProjetoDAO;
import br.com.cmdev.jaxrsejersey.model.Projeto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/projetos")
public class ProjetoResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String listar(@PathParam("id") Long id) {
		Projeto projeto = new ProjetoDAO().busca(id);
		return projeto.toXML();
	}
}
