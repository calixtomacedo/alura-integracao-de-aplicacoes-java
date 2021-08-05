package br.com.cmdev.jaxrsejersey.resource;

import static org.junit.jupiter.api.Assertions.*;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.jaxrsejersey.Servidor;
import br.com.cmdev.jaxrsejersey.model.Carrinho;
import br.com.cmdev.jaxrsejersey.model.Produto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

class CarrinhoResourceTest {
	
	private HttpServer server;

	@BeforeEach
	public void startServer() {
		server = Servidor.start();
	}
	
	@AfterEach
	public void endServer() {
		Servidor.stop(server);
	}
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8086");
		String response = target.path("/carrinhos/1").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(response);
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}

	@Test
	public void testaAdiocionarNovoProjeto() {
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8086");
        
        Carrinho carrinho = new Carrinho();
        carrinho.adiciona(new Produto(314L, "Tablet", 999, 1));
        carrinho.setRua("Rua Paulo Cesar Ribeiro 1065");
        carrinho.setCidade("Osasco");
        String xml = carrinho.toXML();
        
        Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/carrinhos").request().post(entity);
        
        assertEquals("Created", response.readEntity(String.class));
	}

}
