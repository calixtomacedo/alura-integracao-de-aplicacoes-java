package br.com.cmdev.jaxrsejersey;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static void main(String[] args) throws IOException {
		HttpServer server = start();
		System.in.read();
		stop(server);
	}

	public static void stop(HttpServer server) {
		server.shutdown();
		System.out.println("Parando o servidor.");
	}

	public static HttpServer start() {
		URI uri = URI.create("http://localhost:8086");
		ResourceConfig config = new ResourceConfig().packages("br.com.cmdev.jaxrsejersey");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("Iniciando o servidor... ");
		return server;
	}
}
