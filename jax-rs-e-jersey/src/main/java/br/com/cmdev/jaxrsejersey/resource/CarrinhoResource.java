package br.com.cmdev.jaxrsejersey.resource;

import java.net.URI;

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.jaxrsejersey.dao.CarrinhoDAO;
import br.com.cmdev.jaxrsejersey.model.Carrinho;
import br.com.cmdev.jaxrsejersey.model.Produto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/carrinhos")
public class CarrinhoResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") Long id) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho.toXML();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(String request, @Context UriInfo uriInfo) {
		Carrinho carrinho = (Carrinho) new XStream().fromXML(request);
		new CarrinhoDAO().adiciona(carrinho);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI uri = uriBuilder.path(Long.toString(carrinho.getId())).build();
		return Response.created(uri).build();
	}
	
	@Path("{id}/produtos/{produtoId}")
	@DELETE
	public Response removeProduto(@PathParam("id") Long id, @PathParam("produtoId") Long produtoId) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		carrinho.remove(produtoId);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{produtoId}")
	@PUT
	public Response alteraProduto(String request, @PathParam("id") Long id, @PathParam("produtoId") Long produtoId) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(request);
		carrinho.troca(produto);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{produtoId}/quantidade")
	@PUT
	public Response alteraProdutoQuantidade(String request, @PathParam("id") Long id, @PathParam("produtoId") Long produtoId) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(request);
		carrinho.trocaQuantidade(produto);
		return Response.ok().build();
	}
	
	
}
