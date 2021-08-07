package br.com.cmdev.estoquews.ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.cmdev.estoquews.dao.ItemDao;
import br.com.cmdev.estoquews.model.Item;
import br.com.cmdev.estoquews.model.ListaItens;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "listarTodosItens")
	@WebResult(name = "itens")
	public ListaItens getItens() {
		
		ArrayList<Item> items = dao.todosItens();

		return new ListaItens(items);
	}

}
