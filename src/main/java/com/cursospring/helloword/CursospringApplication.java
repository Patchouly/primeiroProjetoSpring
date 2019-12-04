package com.cursospring.helloword;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursospring.helloword.domain.Categoria;
import com.cursospring.helloword.repositories.CategoriaReposiroty;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaReposiroty categoriaReposiroty;

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaReposiroty.saveAll(Arrays.asList(cat1, cat2));
	}
	
	

}
