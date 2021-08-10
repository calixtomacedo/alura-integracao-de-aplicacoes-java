package br.com.cmdev.tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import br.com.cmdev.model.Produto;

public class ReaderXmlStax {

	private static List<Produto> produtos = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		InputStream inputStream = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = factory.createXMLEventReader(inputStream);

		Produto produto = null;
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
				produto = new Produto();
			} else if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
				event = eventReader.nextEvent();
				String nome = event.asCharacters().getData();
				produto.setNome(nome);
			} else if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("preco")) {
				event = eventReader.nextEvent();
				String preco = event.asCharacters().getData();
				produto.setPreco(Double.parseDouble(preco));
			}
			else if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
				produtos.add(produto);
			}
		}
		
		System.out.println(produtos);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
