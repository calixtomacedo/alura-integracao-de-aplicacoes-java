package br.com.cmdev.jaxrsejersey.resource;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cmdev.jaxrsejersey.Servidor;
import br.com.cmdev.jaxrsejersey.model.Carrinho;
import br.com.cmdev.jaxrsejersey.model.Produto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CarrinhoResourceTest {
	
	private HttpServer server;
	private Client client;
	private WebTarget target;

	@BeforeEach
	public void startServer() {
		this.server = Servidor.start();
		this.client = ClientBuilder.newClient(createClientConfig());
		this.target = client.target("http://localhost:8086");
	}

	protected static ClientConfig createClientConfig() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		return config;
	}

	@AfterEach
	public void endServer() {
		Servidor.stop(server);
	}
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Carrinho carrinho = target.path("/carrinhos/1").request().get(Carrinho.class);
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}

	@Test
	public void testaAdiocionarNovoProjeto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adiciona(new Produto(314L, "Tablet 2", 999, 2));
        carrinho.setRua("Rua Paulo Cesar Ribeiro 1065");
        carrinho.setCidade("Osasco");
        
        Entity<Carrinho> request = Entity.entity(carrinho, MediaType.APPLICATION_XML);
        Response response = target.path("/carrinhos").request().post(request);
        assertEquals(201, response.getStatus());
        
        String location = response.getHeaderString("Location");
        Carrinho carrinhoResponse = client.target(location).request().get(Carrinho.class);
        String nome = carrinhoResponse.getProdutos().get(0).getNome();
        assertEquals("Tablet 2", nome);
	}

}
*/

