package br.com.cmdev.jaxrsejersey;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ResourceConfig {

	public Application() {
        packages("br.com.cmdev.jaxrsejersey.resource");
    }
}
