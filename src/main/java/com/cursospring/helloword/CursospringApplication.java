package com.cursospring.helloword;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursospring.helloword.domain.Categoria;
import com.cursospring.helloword.domain.Produto;
import com.cursospring.helloword.repositories.CategoriaReposiroty;
import com.cursospring.helloword.repositories.ProdutoReposiroty;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaReposiroty categoriaReposiroty;
	@Autowired
	private ProdutoReposiroty produtoReposiroty;

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 12.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaReposiroty.saveAll(Arrays.asList(cat1, cat2));
		produtoReposiroty.saveAll(Arrays.asList(prod1, prod2, prod3));
		
	}
	
	

}
