package br.com.cmdev.jaxrsejersey;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static void main(String[] args) throws IOException {
		URI uri = URI.create("http://localhost:8086");
		ResourceConfig config = new ResourceConfig().packages("br.com.cmdev.jaxrsejersey");
		try {
			final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
			
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					server.shutdownNow();
				}
			}));
			
			server.start();

			System.out.println(String.format("Servidor rodando%n" + "Pare o servidor usando CTRL+C"));

			Thread.currentThread().join();
			
		} catch (IOException | InterruptedException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
