package br.com.cmdev.estoquews.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

import br.com.cmdev.estoquews.dao.ItemDao;
import br.com.cmdev.estoquews.model.Filtro;
import br.com.cmdev.estoquews.model.Filtros;
import br.com.cmdev.estoquews.model.Item;
import br.com.cmdev.estoquews.model.ListaItens;

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

}
