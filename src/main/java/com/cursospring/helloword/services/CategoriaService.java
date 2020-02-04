package com.cursospring.helloword.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cursospring.helloword.domain.Categoria;
import com.cursospring.helloword.repositories.CategoriaReposiroty;
import com.cursospring.helloword.services.exceptions.DataIntegrityException;
import com.cursospring.helloword.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaReposiroty repo;
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow ( 
				() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()) 
			);
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir uma categoria com produtos!");
		}
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	//Busca paginada
	public Page<Categoria> findByPage(Integer page, Integer rows, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, rows, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
