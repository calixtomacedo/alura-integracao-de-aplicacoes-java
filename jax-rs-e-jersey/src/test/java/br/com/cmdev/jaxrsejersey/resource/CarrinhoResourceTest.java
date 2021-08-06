package br.com.cmdev.jaxrsejersey.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
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
		String response = target.path("/carrinhos/1").request().get(String.class);
		Carrinho carrinho = (Carrinho) new XStream().fromXML(response);
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}

	@Test
	public void testaAdiocionarNovoProjeto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adiciona(new Produto(314L, "Tablet 2", 999, 2));
        carrinho.setRua("Rua Paulo Cesar Ribeiro 1065");
        carrinho.setCidade("Osasco");
        String xml = carrinho.toXML();
        
        Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/carrinhos").request().post(entity);
        assertEquals(201, response.getStatus());
        
        String location = response.getHeaderString("Location");
        String resposta = client.target(location).request().get(String.class);
        assertTrue(resposta.contains("Tablet"));
	}

}
