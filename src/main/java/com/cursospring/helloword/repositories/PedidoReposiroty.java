package com.cursospring.helloword.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.helloword.domain.Pedido;

@Repository
public interface PedidoReposiroty extends JpaRepository<Pedido, Integer> {

}
