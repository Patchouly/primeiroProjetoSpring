package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Pagamento;

@Repository
public interface PagamentoReposiroty extends JpaRepository<Pagamento, Integer> {

}
