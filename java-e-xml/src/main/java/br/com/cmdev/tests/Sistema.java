package br.com.cmdev.tests;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.cmdev.model.Produto;

public class Sistema {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
		
		//getNome(document);
		
		percorreXML(document);
	}
/*
	private static void getNome(Document document) throws ParserConfigurationException, SAXException, IOException {
		NodeList nome = document.getElementsByTagName("nome");
		Element elementNome = (Element) nome.item(0);
		String nomeProduto = elementNome.getTextContent();
		System.out.println(nomeProduto);
	}
*/
	private static void percorreXML(Document document) {
		NodeList nodeList = document.getElementsByTagName("produto");
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			String nome = element.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(element.getElementsByTagName("preco").item(0).getTextContent());
			
			Produto produto = new Produto(nome, preco);
			
			System.out.println(produto);
		}
	}
}
