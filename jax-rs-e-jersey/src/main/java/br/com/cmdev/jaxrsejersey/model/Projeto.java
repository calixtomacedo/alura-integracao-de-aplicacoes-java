package br.com.cmdev.jaxrsejersey.model;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Projeto {
	private long id;
	private String nome;
	private int anoDeInicio;
	
	public Projeto(long id, String nome, int anoDeInicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoDeInicio = anoDeInicio;
	}
	
	public Projeto() {}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}
	
	public String toXML() {
	    return new XStream().toXML(this);
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
}
