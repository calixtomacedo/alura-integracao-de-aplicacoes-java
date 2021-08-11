package br.com.cmdev.tests;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.cmdev.model.Produto;
import br.com.cmdev.model.Venda;

public class ConversorXml {

	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		xmlToObject(jaxbContext);
		
		objectToXml(jaxbContext);
	}


	private static void xmlToObject(JAXBContext jaxbContext) throws Exception {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);
	}
	
	private static void objectToXml(JAXBContext jaxbContext) throws Exception {
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("Tarmac S-WORKS 2022", 100.000));
		produtos.add(new Produto("EPIC S-WORKS 2022", 90.000));
		
		Venda venda = new Venda();
		venda.setFormaDePagamento("Cartão");
		venda.setProdutos(produtos);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);

		System.out.println(writer.toString());
	}

}
