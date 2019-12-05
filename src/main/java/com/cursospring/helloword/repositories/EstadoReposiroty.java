package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Estado;

@Repository
public interface EstadoReposiroty extends JpaRepository<Estado, Integer> {

}
