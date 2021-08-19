package br.com.cmdev.leilaows.resource;

import java.util.List;

import br.com.cmdev.leilaows.model.Usuario;
import br.com.cmdev.leilaows.repository.UsuarioRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/usuario")
public class UsuarioResource {
	
	@GET
	@Path("list")
	public Response index() {
		List<Usuario> usuarios = UsuarioRepository.getInstance().findAll();
		GenericEntity<List<Usuario>> genericList = new GenericEntity<List<Usuario>>(usuarios){};
		return Response.ok(genericList).build();
	}
	
	@GET
	@Path("{id}")
	public Usuario getUsuario(@PathParam("id") Long id) {
		Usuario usuario = UsuarioRepository.getInstance().find(id);
		return usuario;
	}
	
	@POST
	public Response create(Usuario usuario, @Context UriInfo uriInfo) {
		UsuarioRepository.getInstance().create(usuario);
		return Response.status(Response.Status.CREATED).entity(UsuarioRepository.getInstance().find(usuario.getId())).build();
	}

}