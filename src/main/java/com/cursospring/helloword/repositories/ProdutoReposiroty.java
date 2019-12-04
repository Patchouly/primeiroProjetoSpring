package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Produto;

@Repository
public interface ProdutoReposiroty extends JpaRepository<Produto, Integer> {

}
