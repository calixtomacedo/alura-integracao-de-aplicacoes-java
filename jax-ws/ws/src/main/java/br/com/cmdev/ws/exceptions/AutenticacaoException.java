package br.com.cmdev.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "AutenticacaoFault")
public class AutenticacaoException extends Exception {
	private static final long serialVersionUID = 6807798379234846998L;

	public AutenticacaoException(String mensagem) {
		super(mensagem);
	}
	
	public String getFaultInfo() {
		return "Token inválido";
	}
}
