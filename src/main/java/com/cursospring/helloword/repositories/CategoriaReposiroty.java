package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Categoria;

@Repository
public interface CategoriaReposiroty extends JpaRepository<Categoria, Integer> {

}
