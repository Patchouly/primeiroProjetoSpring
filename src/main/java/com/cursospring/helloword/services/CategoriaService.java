package com.cursospring.helloword.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.helloword.domain.Categoria;
import com.cursospring.helloword.repositories.CategoriaReposiroty;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaReposiroty categoriaReposiroty;
	
	public Categoria buscaCategoria(Integer id) {
		Optional<Categoria> obj = categoriaReposiroty.findById(id);
		return obj.orElse(null);
	}
}
