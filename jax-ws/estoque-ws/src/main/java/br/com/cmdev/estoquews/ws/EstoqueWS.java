package br.com.cmdev.estoquews.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import br.com.cmdev.estoquews.dao.ItemDao;
import br.com.cmdev.estoquews.model.Item;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	public List<Item> getItens() {
		System.out.println("Chamando getItens()");
		ArrayList<Item> items = dao.todosItens();
		return items;
	}

}
