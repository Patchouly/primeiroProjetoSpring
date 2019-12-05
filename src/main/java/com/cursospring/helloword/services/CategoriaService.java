package com.cursospring.helloword.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.helloword.domain.Categoria;
import com.cursospring.helloword.repositories.CategoriaReposiroty;
import com.cursospring.helloword.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaReposiroty categoriaReposiroty;
	
	public Categoria buscaCategoria(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = categoriaReposiroty.findById(id);
		return obj.orElseThrow ( 
				() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()) 
			);
	}
}
