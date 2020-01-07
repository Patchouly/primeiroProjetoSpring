package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Endereco;

@Repository
public interface EnderecoReposiroty extends JpaRepository<Endereco, Integer> {

}
