package br.com.cmdev.leilaows;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
public class Configuration extends Application {
	
	public Configuration() {
		System.out.println("Subindo a aplicação, lendo a classe: "+this.getClass().getName());
	}
	
}
