package br.com.cmdev.jaxrsejersey;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.Test;


public class ClientTest {

	@Test
	public void testaQueAConexaoComOServidorFunciona() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io");
		String response = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		
		System.out.println(response);
		
		assertTrue(response.contains("<rua>Rua Vergueiro 3185"));
	}
}
