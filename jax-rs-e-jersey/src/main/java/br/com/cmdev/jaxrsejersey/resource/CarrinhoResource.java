package br.com.cmdev.jaxrsejersey.resource;

import org.glassfish.grizzly.http.util.HttpStatus;

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.jaxrsejersey.dao.CarrinhoDAO;
import br.com.cmdev.jaxrsejersey.model.Carrinho;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("carrinhos")
public class CarrinhoResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") Long id) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho.toXML();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String adiciona(String request) {
		Carrinho carrinho = (Carrinho) new XStream().fromXML(request);
		new CarrinhoDAO().adiciona(carrinho);
		return HttpStatus.CREATED_201.getReasonPhrase();
	}
}
