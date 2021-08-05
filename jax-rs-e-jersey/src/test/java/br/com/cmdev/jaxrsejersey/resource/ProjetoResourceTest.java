package br.com.cmdev.jaxrsejersey.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.jaxrsejersey.Servidor;
import br.com.cmdev.jaxrsejersey.model.Projeto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class ProjetoResourceTest {

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
	public void testaBuscaProjetoPassandoUmId() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8086");
		Projeto response = (Projeto) new XStream().fromXML(webTarget.path("/projetos").request().get(String.class));
		assertEquals(response.getNome(), "Minha loja");
	}
}
