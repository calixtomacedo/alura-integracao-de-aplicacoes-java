package br.com.cmdev.leilaows.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import br.com.cmdev.leilaows.model.Usuario;

public class UsuarioRepository {
	
	private static UsuarioRepository instance;
	
	public static UsuarioRepository getInstance() {
		if(instance == null) {
			instance = new UsuarioRepository();
		}
		return instance;
	}

	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	static {
		usuarios.add(new Usuario(1L, "Calixto Macedo", "calixto.macedo@gmail.com"));
		usuarios.add(new Usuario(2L, "Rosimeire Cunegundes", "rosy.macedo@gmail.com"));
	}

	public void create(Usuario entity) {
		entity.setId(Math.abs(new Random().nextLong()));
		usuarios.add(entity);
	}

	public Usuario update(Usuario entity) {
		delete(entity);

		usuarios.add(entity);
		return entity;
	}

	private void delete(Usuario entity) {
		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			Usuario current = it.next();
			System.out.println("current " + current);
			System.out.println("entity " + entity);
			if (current.getId() == entity.getId()) {
				it.remove();
				break;
			}
		}
	}

	public void destroy(Usuario entity) {
		delete(entity);
	}

	public Usuario find(Long id) {
		for (Usuario u : usuarios) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}

	public List<Usuario> findAll() {
		return Collections.unmodifiableList(usuarios);
	}

}
