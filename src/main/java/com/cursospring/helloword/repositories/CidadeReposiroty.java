package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Cidade;

@Repository
public interface CidadeReposiroty extends JpaRepository<Cidade, Integer> {

}
