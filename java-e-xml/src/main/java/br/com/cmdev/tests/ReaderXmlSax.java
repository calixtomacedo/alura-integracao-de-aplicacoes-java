package br.com.cmdev.tests;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import br.com.cmdev.utils.ProdutoHandler;

public class ReaderXmlSax {


	public static void main(String[] args) throws Exception {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		XMLReader reader = parserFactory.newSAXParser().getXMLReader();
		
		ProdutoHandler produtoHandler = new ProdutoHandler();
		reader.setContentHandler(produtoHandler);
		
		InputStream inputStream = new FileInputStream("src/vendas.xml");
		InputSource inputSource = new InputSource(inputStream); 
		reader.parse(inputSource);
		
		System.out.println(produtoHandler.getProdutos());
	}

}
