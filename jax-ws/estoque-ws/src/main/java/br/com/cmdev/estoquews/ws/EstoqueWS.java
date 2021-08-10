package br.com.cmdev.estoquews.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

import br.com.cmdev.estoquews.dao.ItemDao;
import br.com.cmdev.estoquews.dao.TokenDao;
import br.com.cmdev.estoquews.exceptions.AutenticacaoException;
import br.com.cmdev.estoquews.model.Filtro;
import br.com.cmdev.estoquews.model.Filtros;
import br.com.cmdev.estoquews.model.Item;
import br.com.cmdev.estoquews.model.ListaItens;
import br.com.cmdev.estoquews.model.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName = "listarTodosItens")
	@ResponseWrapper(localName = "todosItens")
	@WebResult(name = "itens")
	public List<Item> getItens() {
		return dao.todosItens();
	}
		
	@WebMethod(operationName = "listarItensPorFiltro")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "itens")
	public ListaItens getItensByFilter(@WebParam(name="filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return new ListaItens(itensResultado);
	}
	
	@WebMethod(operationName = "cadastrarItem")
	@WebResult(name = "item")
	public Item cadastarItem(@WebParam(name = "item") Item item, @WebParam(name = "token", header = true) TokenUsuario token) throws AutenticacaoException {
		System.out.println("Cadastrando um Item: " + item +" Token: " + token);
		
		boolean ehValido = new TokenDao().ehValido(token);
		if(!ehValido) {
			throw new AutenticacaoException("Falha na autenticação");
		}
		
		this.dao.cadastrar(item);
		
		return item;
	}

}
