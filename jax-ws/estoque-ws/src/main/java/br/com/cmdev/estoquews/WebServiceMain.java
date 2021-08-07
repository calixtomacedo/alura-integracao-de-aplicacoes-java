package br.com.cmdev.estoquews;

import javax.xml.ws.Endpoint;

import br.com.cmdev.estoquews.ws.EstoqueWS;

public class WebServiceMain {

	public static void main(String[] args) {

		EstoqueWS service = new EstoqueWS();
		String url = "http://localhost:8080/estoquews";
		
		Endpoint.publish(url, service);
	}

}
