package br.com.cmdev.jaxrsejersey.resource;

import br.com.cmdev.jaxrsejersey.dao.ProjetoDAO;
import br.com.cmdev.jaxrsejersey.model.Projeto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/projetos")
public class ProjetoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String listar() {
		Projeto projeto = new ProjetoDAO().busca(1l);
		return projeto.toXML();
	}
}
