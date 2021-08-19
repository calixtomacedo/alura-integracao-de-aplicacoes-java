package br.com.cmdev.leilaows.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.cmdev.leilaows.model.Leilao;
import br.com.cmdev.leilaows.model.Usuario;

public class LeilaoRepository {

	private static List<Leilao> leiloes = new ArrayList<Leilao>();

	static {

		Usuario mauricio = new Usuario(1L, "Calixto Macedo", "calixto.macedo@gmail.com");
		Usuario guilherme = new Usuario(2L, "Rosimeire Cunegundes", "rosy.macedo@gmail.com");

		Leilao l1 = new Leilao(1l, "Geladeira", 800.0, mauricio, false);
		Leilao l2 = new Leilao(2l, "XBox", 450.0, guilherme, false);
		leiloes.add(l1);
		leiloes.add(l2);
	}

	public void create(Leilao entity) {
		leiloes.add(entity);

	}

	private void delete(Leilao entity) {
		Iterator<Leilao> it = leiloes.iterator();
		while (it.hasNext()) {
			Leilao current = it.next();
			if (current.getId() == entity.getId()) {
				it.remove();
				break;
			}
		}
	}

	public Leilao update(Leilao entity) {
		delete(entity);
		leiloes.add(entity);
		return entity;
	}

	public void destroy(Leilao entity) {
		delete(entity);

	}

	public Leilao find(Long id) {
		for (Leilao u : leiloes) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}

	public List<Leilao> findAll() {
		return Collections.unmodifiableList(leiloes);
	}

}
