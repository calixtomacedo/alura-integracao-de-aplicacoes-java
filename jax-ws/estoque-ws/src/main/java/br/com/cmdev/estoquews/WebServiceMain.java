package br.com.cmdev.estoquews;

import javax.xml.ws.Endpoint;

import br.com.cmdev.estoquews.ws.EstoqueWS;

public class WebServiceMain {

	public static void main(String[] args) {

		EstoqueWS service = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		
		System.out.println("Serviço inicializado: "+ url +"?wsdl");
		
		Endpoint.publish(url, service);
	}

}
