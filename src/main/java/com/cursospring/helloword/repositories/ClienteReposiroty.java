package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Cliente;

@Repository
public interface ClienteReposiroty extends JpaRepository<Cliente, Integer> {

}
