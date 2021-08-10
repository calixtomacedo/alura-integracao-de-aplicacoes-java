package br.com.cmdev.ws;

import javax.xml.ws.Endpoint;

import br.com.cmdev.ws.service.EstoqueWS;

public class WebServiceMain {

	public static void main(String[] args) {

		EstoqueWS service = new EstoqueWS();
		String url = "http://localhost:8082/estoquews";
		
		System.out.println("Serviço inicializado: "+ url +"?wsdl");
		
		Endpoint.publish(url, service);
	}

}
