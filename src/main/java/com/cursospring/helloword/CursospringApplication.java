package com.cursospring.helloword;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursospring.helloword.domain.Categoria;
import com.cursospring.helloword.domain.Cidade;
import com.cursospring.helloword.domain.Cliente;
import com.cursospring.helloword.domain.Endereco;
import com.cursospring.helloword.domain.Estado;
import com.cursospring.helloword.domain.Produto;
import com.cursospring.helloword.domain.enums.TipoCliente;
import com.cursospring.helloword.repositories.CategoriaReposiroty;
import com.cursospring.helloword.repositories.CidadeReposiroty;
import com.cursospring.helloword.repositories.ClienteReposiroty;
import com.cursospring.helloword.repositories.EnderecoReposiroty;
import com.cursospring.helloword.repositories.EstadoReposiroty;
import com.cursospring.helloword.repositories.ProdutoReposiroty;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaReposiroty categoriaReposiroty;
	@Autowired
	private ProdutoReposiroty produtoReposiroty;
	@Autowired
	private EstadoReposiroty estadoReposiroty;
	@Autowired
	private CidadeReposiroty cidadeReposiroty;
	@Autowired
	private EnderecoReposiroty enderecoReposiroty;
	@Autowired
	private ClienteReposiroty clienteReposiroty;

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
		
		Estado est1 = new Estado(null, "Sergipe");
		Estado est2 = new Estado(null, "Pernambuco");
		
		Cidade cid1 = new Cidade(null, "Aracaju", est1);
		Cidade cid2 = new Cidade(null, "Recife", est2);
		Cidade cid3 = new Cidade(null, "Ipojuca", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoReposiroty.saveAll(Arrays.asList(est1, est2));
		cidadeReposiroty.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "Pedro Cardoso", "pedro@mail.com", "01663010510", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("991020636", "32171931"));
		
		Endereco end1 = new Endereco(null, "Rua M", "51", "Apto 303", "Luzia", "49030300", cli1, cid1);
		Endereco end2 = new Endereco(null, "Av Quirino", "85b", "Apto 207", "Inacio Barbosa", "49045700", cli1, cid1);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteReposiroty.saveAll(Arrays.asList(cli1));
		enderecoReposiroty.saveAll(Arrays.asList(end1, end2));
	}
	
	

}
