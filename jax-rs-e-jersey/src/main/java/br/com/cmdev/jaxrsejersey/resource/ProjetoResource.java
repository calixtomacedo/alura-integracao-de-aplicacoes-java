package br.com.cmdev.jaxrsejersey.resource;

import java.net.URI;

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.jaxrsejersey.dao.ProjetoDAO;
import br.com.cmdev.jaxrsejersey.model.Projeto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/projetos")
public class ProjetoResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@PathParam("id") Long id) {
		Projeto projeto = new ProjetoDAO().busca(id);
		return projeto.toJson();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(String request) {
		Projeto projeto = (Projeto) new XStream().fromXML(request);
		new ProjetoDAO().adiciona(projeto);
		URI uri = URI.create("/projetos/" + projeto.getId());
		return Response.created(uri).build();
	}
	
	@Path("{id}")
	@DELETE
	public Response remove(@PathParam("id") Long id) {
		new ProjetoDAO().remove(id);
		return Response.ok().build();
	}
	
}
