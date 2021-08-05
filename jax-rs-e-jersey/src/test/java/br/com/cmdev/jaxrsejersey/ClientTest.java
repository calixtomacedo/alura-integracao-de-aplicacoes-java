package br.com.cmdev.jaxrsejersey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thoughtworks.xstream.XStream;

import br.com.cmdev.jaxrsejersey.model.Carrinho;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;


public class ClientTest {
	
	private HttpServer server;
/*
	@Test
	public void testaQueAConexaoComOServidorFunciona() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io");
		String response = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		
		assertTrue(response.contains("<rua>Rua Vergueiro 3185"));
	}
*/
	
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
		String response = target.path("/carrinhos").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(response);
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
}
