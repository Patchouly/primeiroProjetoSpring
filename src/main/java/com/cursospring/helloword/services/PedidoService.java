package com.cursospring.helloword.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.helloword.domain.Pedido;
import com.cursospring.helloword.repositories.PedidoReposiroty;
import com.cursospring.helloword.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	private PedidoReposiroty repo;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow ( 
				() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName()) 
			);
	}
}