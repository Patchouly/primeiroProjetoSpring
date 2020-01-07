package com.cursospring.helloword.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.helloword.domain.Cliente;
import com.cursospring.helloword.repositories.ClienteReposiroty;
import com.cursospring.helloword.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteReposiroty repo;
	
	public Cliente buscaCliente(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow ( 
				() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()) 
			);
	}
}