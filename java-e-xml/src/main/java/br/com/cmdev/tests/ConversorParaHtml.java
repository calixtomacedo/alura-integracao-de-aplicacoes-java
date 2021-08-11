package br.com.cmdev.tests;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorParaHtml {

	public static void main(String[] args) throws Exception {

		InputStream xsl = new FileInputStream("src/xmlParaHtml.xsl");
		InputStream dados = new FileInputStream("src/vendas.xml");
		
		Transformer transformer  = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl));
		transformer.transform(new StreamSource(dados), new StreamResult("src/vendas.html"));
		
		
	}

}
