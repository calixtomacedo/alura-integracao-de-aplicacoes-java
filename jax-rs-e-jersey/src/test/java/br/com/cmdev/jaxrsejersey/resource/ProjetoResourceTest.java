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

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.jaxrsejersey.Servidor;
import br.com.cmdev.jaxrsejersey.model.Projeto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class ProjetoResourceTest {

	private HttpServer server;
	private Client client;
	private WebTarget target;

	@BeforeEach
	public void startServer() {
		server = Servidor.start();
		client = ClientBuilder.newClient(createClientConfig());
		target = client.target("http://localhost:8086");
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
	public void testaBuscaProjetoPassandoUmId() {
		String response = target.path("/projetos/1").request().get(String.class);
		Projeto projeto = (Projeto) new XStream().fromXML(response);
		assertEquals(projeto.getNome(), "Minha loja");
	}

}
*/
